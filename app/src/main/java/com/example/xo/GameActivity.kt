package com.example.xo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelStore
import com.example.xo.conset.Conest
import com.example.xo.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var viewBinding : ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.appBarTil.toolBar)
        initView()

    }

    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val name1 = intent.getStringExtra(Conest.firstName)?:""
        val name2 = intent.getStringExtra(Conest.secondName)?:""
        viewBinding.name1.text = name1
        viewBinding.name2.text = name2
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}