package com.example.learnersmarketplace

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.loopj.android.http.RequestParams

class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Find Views

        val username = findViewById<TextInputEditText>(R.id.etUsername)
        val email = findViewById<TextInputEditText>(R.id.etEmail)
        val phone = findViewById<TextInputEditText>(R.id.etPhone)
        val password = findViewById<TextInputEditText>(R.id.etPassword)

        val signupButton = findViewById<MaterialButton>(R.id.btnSignup)
        val loginText = findViewById<TextView>(R.id.txtsignin)

        // Login Text

        loginText.setOnClickListener {
            startActivity(Intent(applicationContext, Signin::class.java))
            finish()
        }

        // Signup Button

        signupButton.setOnClickListener {

            val usernameValue = username.text.toString().trim()
            val emailValue = email.text.toString().trim()
            val phoneValue = phone.text.toString().trim()
            val passwordValue = password.text.toString().trim()

            // TODO:
            // Add validation here later

            val api = "https://shafinats.alwaysdata.net/api/signup"

            val data = RequestParams()
            data.put("username", usernameValue)
            data.put("email", emailValue)
            data.put("phone", phoneValue)
            data.put("password", passwordValue)

            val helper = ApiHelper(applicationContext)

             helper.post(api, data)
        }
    }
}