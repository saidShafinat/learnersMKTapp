package com.example.learnersmarketplace

import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_board)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //find the textview by use of the id
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)

        //access the shared preferences file as used in the API helper
        val prefs = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        //fetch the username (incase there is no username, just use 'user' as the default username)
        val username = prefs.getString("username", "user")

        //bind the name to the textview
        welcomeTextView.text = "Welcome $username"

        //find the progress bar and recycler view by the use of their ids
        val progressbar = findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        //specify the API endpoint
        val api = "https://shafinats.alwaysdata.net/api/getproduct"

        //import the helper class
        val helper = ApiHelper(applicationContext)

        //inside the helper class, access the loadproducts function
        helper.loadProducts(api, recyclerView, progressbar)
    }

}