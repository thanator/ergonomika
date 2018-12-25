package tands.nirergonomika.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import tands.nirergonomika.R
import tands.nirergonomika.enums.Step
import tands.nirergonomika.ui.fragments.StartFragment

/**
 * основная сингл-активити
 */

class MainActivity : FragmentActivity() {

    var step = Step.First

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        when (step) {
            Step.First -> {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.main_layout, StartFragment.newInstance(), "rageComicList")
                    .commit()
                step = Step.Second
            }
        }


    }

}
