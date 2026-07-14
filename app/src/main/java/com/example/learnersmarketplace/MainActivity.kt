package com.example.learnersmarketplace

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnSignIn: MaterialButton
    private lateinit var btnSignUp: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle system bars
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

        // Initialize Views
        btnSignIn = findViewById(R.id.signinbtn)
        btnSignUp = findViewById(R.id.signupbtn)

        // Open Sign In Screen
        btnSignIn.setOnClickListener {
            startActivity(Intent(this, Signin::class.java))
        }

        // Open Sign Up Screen
        btnSignUp.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
    }
}