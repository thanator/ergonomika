package tands.nirergonomika.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import tands.nirergonomika.R

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.start_screen_fragment, container, false)

        view.findViewById<Button>(R.id.button_start).setOnClickListener {
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