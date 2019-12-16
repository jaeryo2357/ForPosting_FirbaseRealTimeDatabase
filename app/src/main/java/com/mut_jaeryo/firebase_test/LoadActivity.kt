package com.mut_jaeryo.firebase_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_load.*

class LoadActivity : AppCompatActivity() {


    companion object
    {
        val TAG = "LoadActivity.class"
        val array = ArrayList<Post>()
        lateinit var adapter : postAdapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        load_recycle.layoutManager = LinearLayoutManager(this)

        adapter = postAdapter(array,this)
        load_recycle.adapter = adapter

        val db = FirebaseFirestore.getInstance()

        db.collection("posts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    array.add(Post(document.data.get("title").toString(),document.data.get("content").toString()))
                    adapter.notifyDataSetChanged()
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}
