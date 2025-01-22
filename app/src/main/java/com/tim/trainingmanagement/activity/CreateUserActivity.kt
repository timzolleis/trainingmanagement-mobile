package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleCreateClerkC

class CreateUserActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var roleSpinner: Spinner
    private lateinit var createUserButton: Button

    private val createClerkC = ExampleCreateClerkC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user_view)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        roleSpinner = findViewById(R.id.role)
        createUserButton = findViewById(R.id.create_user_button)

        createUserButton.setOnClickListener {
            createUser()
        }
    }

    private fun createUser() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val role = roleSpinner.selectedItem.toString()

        val errorMessage = createClerkC.addClerk(username, password, role == "Admin")

        if (errorMessage == null) {
            Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
