package com.siddiq.activitycycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    //overriding of onClick function in the OnCLickListener interface in View class
    /*override fun onClick(p0: View?) {
        Toast.makeText(
            this@LoginActivity,
            "Button has been clicked, Toast successful!",
            Toast.LENGTH_LONG
        ).show()
    }*/

    //declaration of variables
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")
    var nameOfAvenger = "The Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        //REMEMBER to add setContentView before initialisation
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Log In"

        //initialisation of variables
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        var isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }


        //new and easy method of adding click listener: Lambda method
        btnLogin.setOnClickListener {
            //storing the edit text values in variables
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            /*The above declaration of variables should be INSIDE the click listener as
            we will get the value of the edit text only when the login button is pressed.
            Credentials were not there at the time of creation*/

            //creating bridge
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            /*if ((mobileNumber == validMobileNumber)) {
                if (password == validPassword[0]) {
                    nameOfAvenger = "Iron Man"
                    intent.putExtra("Name", nameOfAvenger)
                    //starting the next activity by passing intent
                    startActivity(intent)
                } else if (password == validPassword[1]) {
                    nameOfAvenger = "Captain America"
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[2]) {
                    nameOfAvenger = "The Hulk"
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[3]) {
                    nameOfAvenger = "The Avengers"
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Invalid Credentials",
                        Toast.LENGTH_LONG
                    ).show()//this here is the CONTEXT, when we do it by interface method
                }
            }
            else{
                Toast.makeText(
                    this@LoginActivity,
                    "Invalid Credentials",
                    Toast.LENGTH_LONG
                ).show()//this here is the CONTEXT, when we do it by interface method
            }*/
            when(mobileNumber){
                validMobileNumber -> {
                    when (password) {
                        validPassword[0] -> {
                            nameOfAvenger = "Iron Man"
                            savedPreferences(nameOfAvenger)
                            //intent.putExtra("Name", nameOfAvenger) now no need as we are doing through SP method
                            //starting the next activity by passing intent
                            startActivity(intent)
                        }
                        validPassword[1] -> {
                            nameOfAvenger = "Captain America"
                            savedPreferences(nameOfAvenger)
                            startActivity(intent)
                        }
                        validPassword[2] -> {
                            nameOfAvenger = "The Hulk"
                            savedPreferences(nameOfAvenger)
                            startActivity(intent)
                        }
                        validPassword[3] -> {
                            nameOfAvenger = "The Avengers"
                            savedPreferences(nameOfAvenger)
                            startActivity(intent)
                        }
                        else -> {
                            Toast.makeText(
                                this@LoginActivity,
                                "Invalid Credentials",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
                else -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Invalid Credentials",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savedPreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}