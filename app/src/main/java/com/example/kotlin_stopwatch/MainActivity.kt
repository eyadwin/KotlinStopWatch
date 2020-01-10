package com.example.kotlin_stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity() {
    //Number of seconds displayed on the stopwatch.
    var seconds = 0
    var running: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState!=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        timer()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("seconds", seconds)
        outState?.putBoolean("running", running)
    }
    private fun timer() {
        val handler = Handler()
        handler.post(object : Runnable {

            override fun run() {
                var hours = seconds / 3600
                var minutes = seconds % 3600 / 60
                var secs = seconds % 60

                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
                watchTv.text="$hours:$minutes:$secs";
            }
        })
    }// end timer
    fun clickBtn(view : View){
        when(view.id) {
            R.id.startBtn -> {running = true}
            R.id.stopBtn -> {running = false}
            R.id.resetBtn -> {
                running = false
                seconds = 0
                }
        }
    }// end clickBtn

    }

