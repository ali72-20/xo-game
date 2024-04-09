package com.example.xo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.xo.conset.Conest
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
            if(!valideinput()){
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this,GameActivity::class.java)
            val firstName = viewBinding.contentHome.firstInputEt.text.toString()
            val secondName = viewBinding.contentHome.secondInputEt.text.toString()
            intent.putExtra(Conest.firstName,firstName)
            intent.putExtra(Conest.secondName,secondName)
            startActivity(intent)
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