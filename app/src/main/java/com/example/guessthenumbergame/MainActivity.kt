package com.example.guessthenumber

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.guessthenumbergame.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var randomNumber = 0

    private lateinit var tvInstruction: TextView
    private lateinit var etGuess: EditText
    private lateinit var btnGuess: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInstruction = findViewById(R.id.tvInstruction)
        etGuess = findViewById(R.id.etGuess)
        btnGuess = findViewById(R.id.btnGuess)
        tvResult = findViewById(R.id.tvResult)

        startNewGame()

        btnGuess.setOnClickListener {
            val guess = etGuess.text.toString().toIntOrNull()

            if (guess == null) {
                Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            when {
                guess < randomNumber -> tvResult.text = "Too low! Try again."
                guess > randomNumber -> tvResult.text = "Too high! Try again."
                else -> {
                    tvResult.text = "Correct! Starting new game..."
                    startNewGame()
                }
            }
        }
    }

    private fun startNewGame() {
        randomNumber = Random.nextInt(1, 101)
        etGuess.text.clear()
    }
}