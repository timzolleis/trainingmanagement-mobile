package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleEditClerkC

class EditUserActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var roleSpinner: Spinner
    private lateinit var editUserButton: Button
    private lateinit var cancelButton: Button

    private val editClerkC = ExampleEditClerkC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_user_view)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        roleSpinner = findViewById(R.id.role)
        editUserButton = findViewById(R.id.edit_user_button)
        cancelButton = findViewById(R.id.cancel_button)

        editUserButton.setOnClickListener {
            editUser()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun editUser() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val role = roleSpinner.selectedItem.toString()

        val errorMessage = editClerkC.updateClerk(username, username, password, role == "Admin")

        if (errorMessage == null) {
            Toast.makeText(this, "User edited successfully", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
