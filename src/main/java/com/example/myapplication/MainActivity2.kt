package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val goBack = findViewById<Button>(R.id.goBack)
        goBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


        val date1 = findViewById<Button>(R.id.button10)
        val time1 = findViewById<Button>(R.id.button21)
        val pickingDate = findViewById<LinearLayout>(R.id.pickDate)
        val pickingTime = findViewById<LinearLayout>(R.id.pickTime)
        val blinkAnim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.blink_anim
        )

        date1.setOnClickListener {
            date1.startAnimation(blinkAnim)
            if (pickingDate.getVisibility() == View.INVISIBLE) {
                pickingDate.setVisibility(View.VISIBLE)
            }
        }

        time1.setOnClickListener {
            if (pickingTime.getVisibility() == View.INVISIBLE) {
                pickingTime.setVisibility(View.VISIBLE)
            }
        }


        val plusMinus1 = findViewById<TextView>(R.id.textView34)
        val plusMinus2 = findViewById<TextView>(R.id.textView35)

        val incrementButtonAdult = findViewById<Button>(R.id.incrementAdult)
        val decrementButtonAdult = findViewById<Button>(R.id.decrementAdult)
        val incrementButtonChild = findViewById<Button>(R.id.incrementChild)
        val decrementButtonChild = findViewById<Button>(R.id.decrementChild)
        var countAdult: Int = 0
        var countChild: Int = 0

        var totalPrice = 0
        var adultPrice = 0
        var childPrice = 0
        val totalPriceText = findViewById<TextView>(R.id.totalPrice)


        fun incrementAdult() {
            if (incrementButtonAdult.hasOnClickListeners()) {
                countAdult++
                plusMinus1.setText("" + countAdult)
                adultPrice += 24

            }
        }

        fun incrementChild() {
            if (incrementButtonChild.hasOnClickListeners()) {
                countChild++
                plusMinus2.setText("" + countChild)
                childPrice += 18
            }

        }

        fun decrementAdult() {
            if (decrementButtonAdult.hasOnClickListeners()) {
                if (countAdult <= 0) {
                    countAdult = 0
                    adultPrice = 0
                } else {
                    countAdult--
                    plusMinus1.setText("" + countAdult)
                    if (adultPrice > 0) {
                        adultPrice -= 24
                    }
                }
            }
        }

        fun decrementChild() {
            if (decrementButtonChild.hasOnClickListeners()) {
                if (countChild <= 0) {
                    countChild = 0
                } else {
                    countChild--
                    plusMinus2.setText("" + countChild)
                    if (childPrice > 0) {
                        childPrice -= 18
                    }
                }
            }
        }


        fun finalPriceForTickets() {
            totalPrice = childPrice + adultPrice
            totalPriceText.setText("" + totalPrice)
        }

        incrementButtonAdult.setOnClickListener {
            incrementAdult()
            finalPriceForTickets()
        }

        decrementButtonAdult.setOnClickListener {
            decrementAdult()
            finalPriceForTickets()
        }

        incrementButtonChild.setOnClickListener {
            incrementChild()
            finalPriceForTickets()
        }

        decrementButtonChild.setOnClickListener {
            decrementChild()
            finalPriceForTickets()
        }

        val checkOut = findViewById<Button>(R.id.checkout)
        val summaryText = findViewById<TextView>(R.id.textView8)
        val totalPriceTxt = findViewById<TextView>(R.id.totalPrice)

        checkOut.setOnClickListener{
            var value: String = totalPriceTxt.getText() as String
            var value1: String = date1.getText() as String
            var selectedTime: String = time1.getText() as String
            summaryText.setText("Date Selected is " + value1 + "\n" + "Selected Time is "+ selectedTime
                    + "\n" + "Adult Tickets is " + countAdult + "\n"
                    + "Child Tickets is " + countChild + "\n" + "Total Price is " + value )
            val summaryTextString: String = summaryText.getText().toString()
            val intent1 = Intent(this, MainActivity3::class.java).apply{
                putExtra("abc", summaryTextString)
            }
            startActivity(intent1)
            }
        }
    }