package com.example.xo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xo.databinding.ActivityMainBinding
import com.example.xo.databinding.ActivitySplashScreenBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        startGame()
    }

    private fun startGame() {
        viewBinding.contentHome.startBtn.setOnClickListener {

        }
    }

    private fun valideinput() : Boolean{
        var isValid : Boolean = true;
        val firstName:String = viewBinding.contentHome.firstInputEt.text.toString()
        val secondName: String = viewBinding.contentHome.secondInputEt.text.toString()
        if(firstName.isBlank()){
            viewBinding.contentHome.firstInputTil.error = "Please enter first player"
            isValid = false
        }else{
            viewBinding.contentHome.firstInputTil.error = null
        }

        if(secondName.isBlank()){
            viewBinding.contentHome.secondInputTil.error = "Please enter second player"
            isValid = false
        }else{
            viewBinding.contentHome.secondInputTil.error = null
        }
        return isValid
    }
}