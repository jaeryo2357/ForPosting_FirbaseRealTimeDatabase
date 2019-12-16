package com.mut_jaeryo.firebase_test

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class postAdapter(val array:ArrayList<Post>,val activity: Activity) : RecyclerView.Adapter<postAdapter.PostHolder>() {



    inner class PostHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val title = ItemView.findViewById<TextView>(R.id.post_view_title)
        val content = ItemView.findViewById<TextView>(R.id.post_view_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {

        val view = activity.layoutInflater.inflate(R.layout.post_view,parent,false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = array[position]

        holder.title.text = post.title
        holder.content.text = post.content
    }
}