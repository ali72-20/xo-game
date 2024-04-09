package com.example.xo.startApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.xo.MainActivity
import com.example.xo.R
import com.example.xo.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var viewBinging : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinging = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(viewBinging.root)

        Handler(mainLooper).postDelayed({
            startApp()
        },2000)
    }

    private fun startApp(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}