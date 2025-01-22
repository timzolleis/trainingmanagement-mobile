package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleSelectClerkC

class UserSelectorActivity : AppCompatActivity() {

    private lateinit var userSpinner: Spinner
    private lateinit var confirmButton: Button
    private lateinit var cancelButton: Button

    private val selectClerkC = ExampleSelectClerkC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_selector_view)

        userSpinner = findViewById(R.id.user_spinner)
        confirmButton = findViewById(R.id.confirm_button)
        cancelButton = findViewById(R.id.cancel_button)

        val userNames = selectClerkC.getClerkNames()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, userNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        userSpinner.adapter = adapter

        confirmButton.setOnClickListener {
            val selectedUser = userSpinner.selectedItem.toString()
            // Handle user selection
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}
