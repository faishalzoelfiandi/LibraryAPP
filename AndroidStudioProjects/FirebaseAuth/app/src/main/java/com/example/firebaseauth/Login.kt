package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onStart();
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance();


        val currentuser = mAuth.currentUser
        if(currentuser != null) {
           startActivity(Intent(this@Login,MainActivity::class.java))
        }
        login()
    }
    

}