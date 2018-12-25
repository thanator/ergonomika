package tands.nirergonomika.ui.fragments

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tands.nirergonomika.R

class EndFragment : Fragment() {

    val FLOAT_KEY = "float_key"
    companion object {
        fun newInstance(raiting: Float) = EndFragment().apply {
            arguments = Bundle().apply {
                putFloat(FLOAT_KEY, raiting)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.end_screen, container, false)
    }


}