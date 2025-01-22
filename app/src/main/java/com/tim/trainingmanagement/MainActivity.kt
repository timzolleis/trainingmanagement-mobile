package com.tim.trainingmanagement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.activity.LoginActivity
import com.tim.trainingmanagement.entity.Clerk
import com.tim.trainingmanagement.initialize.setupClerks
import com.tim.trainingmanagement.initialize.setupTrainings

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}