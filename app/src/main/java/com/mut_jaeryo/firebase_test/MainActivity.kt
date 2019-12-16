package com.mut_jaeryo.firebase_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object
    {
        val TAG = "MainActivity.class"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_save.setOnClickListener {
            // Cloud Firestore에 저장
            val db = FirebaseFirestore.getInstance()

            val post = Post(posts_title.text.toString(),posts_content.text.toString()).getHashMap()

            db.collection("posts")
                .add(post)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

        btn_load.setOnClickListener {
            val intent =  Intent(this,LoadActivity::class.java)
            startActivity(intent)
        }

    }

}
