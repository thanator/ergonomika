package tands.nirergonomika.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tands.nirergonomika.R

class ProcessingFragment : Fragment() {

    companion object {
        fun newInstance() = ProcessingFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.processing, container, false)
    }

}