package com.example.erick.clase1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*


class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        closeActivity()
    }

    private fun closeActivity(){
        close_button.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java  ))
        }
    }

}