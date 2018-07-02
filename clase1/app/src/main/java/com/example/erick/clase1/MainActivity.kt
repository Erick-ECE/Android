package com.example.erick.clase1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivity()
        //
        //setUpToolbar()
    }

    private fun openActivity(){
        button_open.setOnClickListener {
            startActivity(Intent(this, PrincipalActivity::class.java))
        }

    }

    private fun setUpToolbar(){
        setSupportActionBar(main_toolbar)
        actionBar.title= "main window"

    }
}
