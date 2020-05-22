package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_profile.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user1: String = "admin@gmail.com"
        val password1: String = "29122000"

        val mail = Regex("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

        fun showProfile() {
            profile_layout.visibility = View.VISIBLE
            home_log.visibility = View.GONE
        }

        fun showLogIn() {
            profile_layout.visibility = View.GONE
            home_log.visibility = View.VISIBLE
        }

        login_btn.setOnClickListener {
            var status: String
            if (mail.matches(username_et.text.toString())) {
                 if (username_et.text.toString().equals(user1) && password_et.text.toString().equals(password1)) {
                     status = "Logged is successfully!"
                     showProfile()
                } else status = "LogIn fail!"
                Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "UserName is incorrect. Please try again.", Toast.LENGTH_SHORT).show()
        }

        logOff_btn.setOnClickListener {
            showLogIn()
        }
    }
}
