package com.example.learnersmarketplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.Animation

class SplashActivity : AppCompatActivity() {

    private lateinit var logo: ImageView
    private lateinit var title: TextView
    private lateinit var tagline: TextView
    private lateinit var iconRow: LinearLayout
    private lateinit var loading: ProgressBar
    private lateinit var loadingText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logo = findViewById(R.id.logo)
        title = findViewById(R.id.title)
        tagline = findViewById(R.id.tagline)
        iconRow = findViewById(R.id.iconRow)
        loading = findViewById(R.id.loading)
        loadingText = findViewById(R.id.loadingText)

        // Hide everything first
        logo.alpha = 0f
        title.alpha = 0f
        tagline.alpha = 0f
        iconRow.alpha = 0f
        loading.alpha = 0f
        loadingText.alpha = 0f

        // Load animations
        val zoom = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        val slide = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)

// Logo
        Handler(Looper.getMainLooper()).postDelayed({

            logo.alpha = 1f
            logo.startAnimation(zoom)

            zoom.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {
                    val floating = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.floating)
                    logo.startAnimation(floating)
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })

        }, 300)
        // Title
        Handler(Looper.getMainLooper()).postDelayed({
            title.alpha = 1f
            title.startAnimation(slide)
        }, 900)

        // Tagline
        Handler(Looper.getMainLooper()).postDelayed({
            tagline.alpha = 1f
            tagline.startAnimation(fade)
        }, 1400)

        // Icons
        Handler(Looper.getMainLooper()).postDelayed({
            iconRow.alpha = 1f
            iconRow.startAnimation(bounce)
        }, 1800)

        // Loading
        Handler(Looper.getMainLooper()).postDelayed({
            loading.alpha = 1f
            loadingText.alpha = 1f

            loading.startAnimation(fade)
            loadingText.startAnimation(fade)

        }, 2300)

        // Go to Home
        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()

        }, 4200)
    }
}