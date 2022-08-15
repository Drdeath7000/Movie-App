package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.widget.Toast
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val totalPriceSummary = findViewById<TextView>(R.id.textView7)
        var bn: Bundle? = getIntent().getExtras()
        var totalPrice: String? = bn?.getString("abc")
        totalPriceSummary.setText((totalPrice))

        val goBackBtn = findViewById<Button>(R.id.goBack1)
        goBackBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }


         fun showDefaultDialog():Int {
            val alertDialog = AlertDialog.Builder(this)
             var answer: Int = 1
             alertDialog.apply {
                 setIcon(R.drawable.smile)
                 setTitle("Hello")
                 setMessage("I just wanted to greet you. I hope you are doing great!")
                 setPositiveButton("Positive", DialogInterface.OnClickListener{ alterDialog, _ ->
                     answer = 1
                     Toast.makeText(applicationContext, "clicked positive button", Toast.LENGTH_SHORT)
                     .show()
                 })
                 setNegativeButton("Negative", DialogInterface.OnClickListener{ _, _ ->
                     answer = 2
                     Toast.makeText(applicationContext, "clicked negative button", Toast.LENGTH_SHORT)
                     .show()

                 })
                 setNeutralButton("Neutral", DialogInterface.OnClickListener{ _, _ ->
                     Toast.makeText(applicationContext, "clicked neutral button", Toast.LENGTH_SHORT)
                     .show()
                     answer = 3

                 })
             }.create().show()
             return answer
        }

        val confirmOrder = findViewById<Button>(R.id.button)
        confirmOrder.setOnClickListener {
            if (showDefaultDialog() == 1) {

                val summaryPage: String = totalPriceSummary.getText().toString()
                val intent1 = Intent(this, MainActivity4::class.java).apply {
                    putExtra("abc", summaryPage)
                }
                startActivity(intent1)

            }
        }

    }

}








