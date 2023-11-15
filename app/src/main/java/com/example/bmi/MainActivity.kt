package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btn)
        val layoutBackground = findViewById<ConstraintLayout>(R.id.backgroundLayout)

        val headingText = findViewById<TextView>(R.id.headingText)
        val bmiText = findViewById<TextView>(R.id.bmiText)
        val conditionText = findViewById<TextView>(R.id.conditionText)

        val weightInput = findViewById<EditText>(R.id.weightText)
        val heightInputFt = findViewById<EditText>(R.id.heightFtText)
        val heightInputInch = findViewById<EditText>(R.id.heightInchText)

        btnCalculate.setOnClickListener{
            if(weightInput.text.toString()!="" && heightInputFt.text.toString()!="" && heightInputInch.text.toString()!=""){
                val weight = (weightInput.text.toString()).toDouble()
                val heightFt = (heightInputFt.text.toString()).toDouble()
                val heightInch = (heightInputInch.text.toString()).toDouble()

                val height = ((heightFt*12 + heightInch)*2.54)/100

                val bmi = weight/(height*height)

                headingText.text = "YOUR BMI"
                bmiText.text = "${bmi.toInt()}"
                if(bmi<=18.5){
                    conditionText.text = "YOU ARE UNDERWEIGHT"
                    layoutBackground.setBackgroundColor(resources.getColor(R.color.lightYellow))
                }
                else if(bmi>18.5 && bmi<=29.9){
                    conditionText.text = "YOU ARE HEALTHY"
                    layoutBackground.setBackgroundColor(resources.getColor(R.color.lightGreen))
                }
                else {
                    conditionText.text = "YOU ARE OVERWEIGHT"
                    layoutBackground.setBackgroundColor(resources.getColor(R.color.lightRed))
                }
            }
            else{
                Toast.makeText(this,"Enter Vaild Credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}