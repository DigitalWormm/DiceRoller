package com.example.testproject

import Dice
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn:Button = findViewById(R.id.btnRoll)

        // Randomly generates a dice upon startup
        rollDice()

        // Creates a message when the roll button is pressed
        rollBtn.setOnClickListener {
            Toast.makeText(this, "Dice Rolled! Yahoo!!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRollResult = dice.logAndRoll()
        val resultTextView:TextView = findViewById(R.id.resultTV)
        val diceImage: ImageView = findViewById(R.id.diceIV)

        // Modify the image of the dice based on the diceRollResult
        val diceImageResult = when (diceRollResult){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        diceImage.setImageResource(diceImageResult)

        // Modify the text of the result Text View
        resultTextView.text = diceRollResult.toString()
    }


}