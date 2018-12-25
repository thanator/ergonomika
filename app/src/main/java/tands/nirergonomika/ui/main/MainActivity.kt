package tands.nirergonomika.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import tands.nirergonomika.R
import tands.nirergonomika.enums.Step
import tands.nirergonomika.processing.MusicFile
import tands.nirergonomika.ui.fragments.EndFragment
import tands.nirergonomika.ui.fragments.ProcessingFragment
import tands.nirergonomika.ui.fragments.StartFragment

/**
 * основная сингл-активити
 */

class MainActivity : FragmentActivity() {

    val step = Step.First
    val musicList : List<MusicFile> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        when (step) {
            Step.First -> {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.main_layout, StartFragment.newInstance(), "rageComicList")
                    .commit()
            }
            Step.Second -> {
            }
            Step.Last -> {
            }
        }



    }

    override fun onAttachFragment(fragment: Fragment?) {

        if (fragment is StartFragment) {

        }
        if (fragment is ProcessingFragment) {

        }
        if (fragment is EndFragment) {

        }
    }




}
