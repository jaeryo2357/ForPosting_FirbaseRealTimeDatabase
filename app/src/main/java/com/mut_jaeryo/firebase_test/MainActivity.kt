package com.mut_jaeryo.firebase_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_save.setOnClickListener {
            // Cloud Firestore에 저장
        }

        btn_load.setOnClickListener {
        //    val intent =  Intent(this,)
        }

    }

}
