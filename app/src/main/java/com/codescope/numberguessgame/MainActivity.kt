package com.codescope.numberguessgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var randomNumber : Int = Random.nextInt(1, 20)
        var triesLeft = 3;
        guessesLeft.text = "You have $triesLeft Guesses Left"


        buttonGuess.setOnClickListener{

            if (userInput.text.toString().toIntOrNull() != null && userInput.text.toString().toIntOrNull() != null) {

                    triesLeft--

                    var userInput = userInput.text.toString().toInt()

                    if (userInput.toInt() == randomNumber ){

                        var intent = Intent(this, success::class.java)
                        intent.putExtra("number", randomNumber.toString())
                        startActivity(intent)


                    }else if (triesLeft>0){

                        MaterialDialog(this).show {
                            title(text = "Incorrect Guess")
                            message(text = "Please try again. You have $triesLeft Guesses Left")
                        }

                        //guessesLeft.text = "${triesLeft.toString()} $randomNumber"
                        guessesLeft.text = "You have $triesLeft Guesses Left"

                    }else{
                        var intent = Intent(this, gameOver::class.java)
                        intent.putExtra("number", randomNumber.toString())
                        startActivity(intent)
                    }
            }else{
                MaterialDialog(this).show {
                    title(text = "Incorrect Input")
                    message(text = "Please enter a valid number")
                }
            }
        }

    }

}
