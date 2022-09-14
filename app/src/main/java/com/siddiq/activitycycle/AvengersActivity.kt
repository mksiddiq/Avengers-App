package com.siddiq.activitycycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = null
    lateinit var btnSend: Button
    lateinit var etMesssage: EditText
    var message: String? = null
    lateinit var btnLogOut: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)

        titleName = sharedPreferences.getString("Title", "The Avengers")
        title = titleName

        btnSend = findViewById(R.id.btnSend)
        etMesssage = findViewById(R.id.etMessage)
        btnLogOut = findViewById(R.id.btnLogOut)

        btnSend.setOnClickListener {
            message = etMesssage.text.toString()
            if (message?.isEmpty() == true) {
                Toast.makeText(
                    this@AvengersActivity,
                    "Please type a Message to send",
                    Toast.LENGTH_SHORT
                ).show()
            } else{
                var intent1 = Intent(this@AvengersActivity, MessageActivity::class.java)
                intent1.putExtra("Message", message)
                Toast.makeText(this@AvengersActivity, "Message Sent!", Toast.LENGTH_LONG).show()
                startActivity(intent1)
            }

        }

        btnLogOut.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            var intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}