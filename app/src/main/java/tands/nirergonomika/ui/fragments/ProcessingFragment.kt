package tands.nirergonomika.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.musicg.wave.Wave
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tands.nirergonomika.R
import tands.nirergonomika.processing.MusicFile
import tands.nirergonomika.processing.Process
import tands.nirergonomika.processing.ProcessImpl

class ProcessingFragment : Fragment() {

    private val KEY_MUSIC = "key music"
    private val KEY_WAVE = "key wave"

    lateinit var wave: Wave
    lateinit var musicFile: MusicFile
    lateinit var process: Process

    companion object {
        fun newInstance(wave: Wave, musicFile: MusicFile) = ProcessingFragment().apply {
            arguments = Bundle().apply {
                putSerializable(KEY_WAVE, wave)
                putSerializable(KEY_MUSIC, musicFile)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.processing_fragment, container, false)
        process = ProcessImpl(activity!!.applicationContext)
        wave = arguments!!.getSerializable(KEY_WAVE) as Wave
        musicFile = arguments!!.getSerializable(KEY_MUSIC) as MusicFile

        val job = GlobalScope.launch { // launch new coroutine and keep a reference to its Job
            process.process(wave)
        }
        // todo корутинка?

        view.findViewById<TextView>(R.id.music_text_view).apply {
            text = musicFile.name
        }

        view.findViewById<Button>(R.id.reselect_button).setOnClickListener {
            activity?.let { activity ->
                activity.supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.main_layout,
                        SearchMusicFragment.newInstance(), "search_fragment"
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }



        view.findViewById<Button>(R.id.start_button).setOnClickListener {

            activity?.let { activity ->
                val fragmentManager = activity.supportFragmentManager
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                fragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.main_layout,
                        EndFragment.newInstance(process.process(wave), wave), "search_fragment"
                    )
                    .commit()
            }
        }

        return view
    }

}