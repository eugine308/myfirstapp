package com.e3.myfirstapp

//import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

//private const val TAG = "MainActivity"
private const val MY_OWN_LOG_TEG = "MyOwnLogTeg"

class MainActivity : AppCompatActivity() {

    private var poemsSizeInt: Int = 0
    private var poemsStrNumberInt: Int = -1
    private var poemsArr: Array<String> = arrayOf()

    private fun poems(activityLifeNameStr: String): String {
        if (poemsStrNumberInt == -1) {
            resources.getStringArray(R.array.poems).also { poemsArr = it }   //val arr: Array<String> = resources.getStringArray(R.array.poems)
            poemsSizeInt = poemsArr.size
        }
        poemsStrNumberInt += 1
        return "${if (poemsStrNumberInt < poemsSizeInt) poemsArr[poemsStrNumberInt] else " "} $activityLifeNameStr $poemsStrNumberInt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            poemsSizeInt = savedInstanceState.getInt("poemsSizeInt")
            poemsStrNumberInt = savedInstanceState.getInt("poemsStrNumberInt")
            savedInstanceState.getStringArray("poemsArr").also {
                if (it != null) {
                    poemsArr = it
                }
            }
        }
        Log.d(MY_OWN_LOG_TEG, poems("onCreate()"))
    }

    override fun onStart() {
        super.onStart()
        Log.d(MY_OWN_LOG_TEG, poems("onStart()"))
    }

    override fun onResume() {
        super.onResume()
        Log.d(MY_OWN_LOG_TEG, poems("onResume()"))
    }

    override fun onPause() {
        super.onPause()
        Log.d(MY_OWN_LOG_TEG, poems("onPause()"))
    }

    override fun onStop() {
        super.onStop()
        Log.d(MY_OWN_LOG_TEG, poems("onStop()"))
    }

    override fun onDestroy() {
        Log.d(MY_OWN_LOG_TEG, poems("onDestroy()"))
        onRetainNonConfigurationInstance()
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MY_OWN_LOG_TEG, poems("onRestart()"))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("poemsSizeInt", poemsSizeInt)
        outState.putInt("poemsStrNumberInt", poemsStrNumberInt+2)
        outState.putStringArray("poemsArr", poemsArr)
    }
}
