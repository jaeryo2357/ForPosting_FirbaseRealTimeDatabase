package com.mut_jaeryo.firebase_test

data class Post(var title:String,var content:String)
{

    fun getHashMap() : HashMap<String,String>
    {
        val hash = hashMapOf<String,String>(
            "title" to title,
            "content" to content
        )

        return hash
    }
}