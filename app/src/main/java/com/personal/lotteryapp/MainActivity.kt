package com.personal.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var editText: TextView
    lateinit var generateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.textView)
        editText = findViewById(R.id.editTextName)
        generateButton = findViewById(R.id.generateBtn)

        generateButton.setOnClickListener {
            val name: String = editText.text.toString()
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("username",name)
            startActivity(i)
        }
    }
}