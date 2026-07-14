package com.example.learnersmarketplace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //find the text view by use of its id
        val signuptxt = findViewById<TextView>(R.id.txtsignup)

        signuptxt.setOnClickListener {
            val newpage = Intent(applicationContext, Signup::class.java)
            startActivity(newpage)
        }

        //find the buttons and the edit text by use of their IDs
        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val signinBtn = findViewById<Button>(R.id.buttonsignin)

        //specify what happens when the button is clicked
        signinBtn.setOnClickListener {
            //set the API endpoint
            val api = "https://shafinats.alwaysdata.net/api/signin"

            //create a request params that acts like an envelope to hold our data
            val data = RequestParams()

            //extract the data from the Edit text and add the same to the RequestParams
            data.put("email", emailEditText.text.toString().trim())
            data.put("password", passwordEditText.text.toString())

            //import API helper class
            val  helper = ApiHelper(applicationContext)

            //access the method post_login in the helper class
            helper.post_login(api,data)
        }

    }
}