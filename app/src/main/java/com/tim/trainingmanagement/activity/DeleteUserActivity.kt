package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleDeleteClerkC

class DeleteUserActivity : AppCompatActivity() {

    private lateinit var deleteUserButton: Button
    private lateinit var cancelButton: Button

    private val deleteClerkC = ExampleDeleteClerkC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.delete_user_view)

        deleteUserButton = findViewById(R.id.delete_user_button)
        cancelButton = findViewById(R.id.cancel_button)

        deleteUserButton.setOnClickListener {
            deleteUser()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun deleteUser() {
        val username = intent.getStringExtra("username")

        if (username != null) {
            val errorMessage = deleteClerkC.deleteClerk(username)

            if (errorMessage == null) {
                Toast.makeText(this, "User deleted successfully", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No user selected", Toast.LENGTH_SHORT).show()
        }
    }
}
