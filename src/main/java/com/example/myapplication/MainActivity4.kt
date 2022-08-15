package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)



        val totalPriceSummary = findViewById<TextView>(R.id.textView14)
        var bn : Bundle? = getIntent().getExtras()
        var totalPrice: String? = bn?.getString("abc")
        totalPriceSummary.setText((totalPrice))

    }
}