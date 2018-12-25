package tands.nirergonomika

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import tands.nirergonomika.processing.MusicFile

/**
 * для мультидекса
 */

class NirApplication : MultiDexApplication() {

    val MusicFile: MusicFile = tands.nirergonomika.processing.MusicFile

    override fun onCreate() {
        super.onCreate()
//        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
//            override fun onActivityPaused(activity: Activity?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onActivityResumed(activity: Activity?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onActivityStarted(activity: Activity?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onActivityDestroyed(activity: Activity?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onActivityStopped(activity: Activity?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }
//        )


    }


}