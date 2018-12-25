package tands.nirergonomika.ui.fragments

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.musicg.wave.Wave
import com.musicg.wave.WaveHeader
import tands.nirergonomika.R
import tands.nirergonomika.processing.MusicFile
import java.io.File

class SearchMusicAdapter(val items: List<MusicFile>, private val runTopCallback: (Wave) -> Unit) : RecyclerView.Adapter<SearchMusicAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
            SearchViewHolder(parent.inflate(R.layout.one_music_file), runTopCallback)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(viewHolder: SearchViewHolder, position: Int) {
        viewHolder.bind(items[position])
    }

    class SearchViewHolder(view: View, private val runTopCallback: (Wave) -> Unit) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.one_music_file_text_view)

        fun bind(musicFile: MusicFile) {
            textView.text = musicFile.name
            textView.isClickable = true
            textView.setOnClickListener {

                runTopCallback.invoke(Wave(WaveHeader(), File(musicFile.fullPath).readBytes()))
            }
        }

    }

    fun ViewGroup.inflate(@LayoutRes resource: Int): View {
        return LayoutInflater.from(this.context).inflate(resource, this, false)
    }


}