package com.siddiq.activitycycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    lateinit var txtMessage: TextView
    var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        txtMessage = findViewById(R.id.txtMessage)

        if(intent != null){
            message = intent.getStringExtra("Message")
            txtMessage.text = message
        }

        title = "Message"


    }
}