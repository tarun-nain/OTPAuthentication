package com.tutorial.lws.otpauthentication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.jvm.java

class SignedIn : AppCompatActivity() {

    private lateinit var tvPhoneNumber: TextView
    private lateinit var btnSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signed_in)

        findViews()

        setPhoneNumber()

        btnSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@SignedIn, MainActivity::class.java))
            finish()
        }
    }

    private fun findViews() {
        tvPhoneNumber = findViewById(R.id.tv_phone_number)
        btnSignOut = findViewById(R.id.btn_sign_out)
    }

    private fun setPhoneNumber() {
        val user = FirebaseAuth.getInstance().currentUser
        try {
            tvPhoneNumber.text = user!!.phoneNumber
        } catch (e: Exception) {
            Toast.makeText(this, "Phone number not found", Toast.LENGTH_SHORT).show()
        }

    }
}
