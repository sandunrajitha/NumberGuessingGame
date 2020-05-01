package com.codescope.numberguessgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_try_again.*

class gameOver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try_again)

        val randomNumber: String = intent.getStringExtra("number")

        textCorrectNumberGO.text = "Correct number is: $randomNumber"


        buttonGameOver.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
