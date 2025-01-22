package com.tim.trainingmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.LoginC
import com.tim.trainingmanagement.initialize.setupClerks
import com.tim.trainingmanagement.initialize.setupTrainings

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var roleSpinner: Spinner
    private lateinit var loginButton: Button

    private val loginC = LoginC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginview)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        roleSpinner = findViewById(R.id.role)
        loginButton = findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            attemptLogin()
        }
        setupClerks();
        setupTrainings();
    }

    private fun attemptLogin() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val role = roleSpinner.selectedItem.toString()

        loginC.printClerkNames();
        val errorMessage = loginC.login(username, password, role == "Admin")

        if (errorMessage == null) {
            val intent = if (role == "Admin") {
                Intent(this, Admin::class.java)
            } else {
                Intent(this, UserActivity::class.java)
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
