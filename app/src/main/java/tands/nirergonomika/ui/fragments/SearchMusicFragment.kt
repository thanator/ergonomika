package tands.nirergonomika.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tands.nirergonomika.R
import tands.nirergonomika.processing.MusicFile


class SearchMusicFragment : Fragment() {

    companion object {
        fun newInstance() = SearchMusicFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.music_searcher_fragment, container, false);

        if (ContextCompat.checkSelfPermission(activity!!.applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(activity!!.applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED
        ) {
            val recyclerView = view.findViewById<RecyclerView>(R.id.search_recycler_view).apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity!!.applicationContext)
                adapter = SearchMusicAdapter(findAllMusic()) { wave ->
                    run {
                        wave.spectrogram.normalizedSpectrogramData
                        activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_layout, ProcessingFragment.newInstance(), "processing_fragment").commit()
                    }
                }
            }
        } else {
            activity?.requestPermissions(
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ), 1
            )
            activity?.let { activity ->
                activity.supportFragmentManager.popBackStack()
            }
        }

        return view
    }

    private fun findAllMusic(): List<MusicFile> {
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"

        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.DATA
        )

        val cursor = activity?.contentResolver?.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null, null
        )

        val listOfNames = ArrayList<MusicFile>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val filepath = java.io.File(cursor.getString(1))
                listOfNames.add(MusicFile(filepath.name, filepath.absolutePath))
            }
            cursor.close()
        }
        return listOfNames
    }

}