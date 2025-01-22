package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleMapTrainingC
import com.tim.trainingmanagement.control.ExampleSelectTrainingC

class AddTrainingMappingActivity : AppCompatActivity() {

    private lateinit var trainingSpinner: Spinner
    private lateinit var attendedSwitch: Switch
    private lateinit var addTrainingButton: Button

    private val selectTrainingC = ExampleSelectTrainingC()
    private val mapTrainingC = ExampleMapTrainingC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_training_mapping_view)

        trainingSpinner = findViewById(R.id.training_spinner)
        attendedSwitch = findViewById(R.id.attended_switch)
        addTrainingButton = findViewById(R.id.add_training_button)

        val trainingNames = selectTrainingC.getAllNames()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, trainingNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        trainingSpinner.adapter = adapter

        addTrainingButton.setOnClickListener {
            addTrainingMapping()
        }
    }

    private fun addTrainingMapping() {
        val trainingName = trainingSpinner.selectedItem.toString()
        val isAttended = attendedSwitch.isChecked

        val errorMessage = if (isAttended) {
            mapTrainingC.attendTraining("clerkName", trainingName)
        } else {
            mapTrainingC.completeTraining("clerkName", trainingName)
        }

        if (errorMessage == null) {
            Toast.makeText(this, "Training mapping added successfully", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
