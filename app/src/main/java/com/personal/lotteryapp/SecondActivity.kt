package com.personal.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    lateinit var textGeneratedNumbers: TextView
    lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textGeneratedNumbers = findViewById(R.id.resultTextView)
        shareButton = findViewById(R.id.shareBtn)

        val randomNumbers = generateRandomNumbers(6)
        textGeneratedNumbers.text = randomNumbers

        val userName = receiveUserName()

        shareButton.setOnClickListener{
            shareResult(userName,randomNumbers)
        }
    }

    fun generateRandomNumbers(count: Int):String{
        var randomNumbers = List(count){
            (0..42).random()
        }
        return randomNumbers.joinToString(" ")
    }

    fun receiveUserName():String {
        var bundle:Bundle? = intent.extras
        var username = bundle?.getString("username").toString()
        return username
    }

    fun shareResult(username:String, generatedNumbers:String){
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT, "The Lottery Numbers are: $generatedNumbers")
        startActivity(i)
    }
}