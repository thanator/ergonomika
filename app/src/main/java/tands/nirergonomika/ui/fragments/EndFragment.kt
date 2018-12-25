package tands.nirergonomika.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.musicg.wave.Wave
import tands.nirergonomika.R
import tands.nirergonomika.ui.SpectrogramView

class EndFragment : Fragment() {

    val KEY = "key"
    val FLOAT_KEY = "float key"
    lateinit var wave: Wave
    var raiting: Float = 0f

    companion object {
        fun newInstance(raiting: Float, wave: Wave) = EndFragment().apply {
            arguments = Bundle().apply {
                putSerializable(KEY, wave)
                putFloat(FLOAT_KEY, raiting)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.end_screen_fragment, container, false)
        wave = arguments!!.getSerializable(KEY) as Wave
        raiting = arguments!!.getFloat(FLOAT_KEY)

        view.findViewById<SpectrogramView>(R.id.spectrogram_view).calculate(wave.spectrogram.absoluteSpectrogramData)

        view.findViewById<TextView>(R.id.music_raiting_text_view).apply {
            text = raiting.toString()
        }

        view.findViewById<Button>(R.id.reselect_button).setOnClickListener {
            activity?.let { activity ->
                activity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_layout,
                                SearchMusicFragment.newInstance(), "search_fragment")
                        .addToBackStack(null)
                        .commit()
            }
        }


        return view
    }


}