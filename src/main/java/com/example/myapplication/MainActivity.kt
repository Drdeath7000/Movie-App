package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


val secondActivityBtn = findViewById<ImageView>(R.id.secondActivityBtn)
secondActivityBtn.setOnClickListener{
    startActivity(Intent(this, MainActivity2::class.java))
}
        val searchView = findViewById<SearchView>(R.id.search)




    }
}