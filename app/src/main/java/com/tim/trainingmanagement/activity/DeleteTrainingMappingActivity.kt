package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleDeleteTrainingMappingC
import com.tim.trainingmanagement.control.ExampleMapTrainingC
import com.tim.trainingmanagement.control.ExampleSelectTrainingC

class DeleteTrainingMappingActivity : AppCompatActivity() {

    private lateinit var trainingSpinner: Spinner
    private lateinit var deleteTrainingMappingButton: Button

    private val deleteTrainingMappingC = ExampleDeleteTrainingMappingC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.delete_training_mapping_view)


        trainingSpinner = findViewById(R.id.training_spinner)
        deleteTrainingMappingButton = findViewById(R.id.delete_training_button)

        val clerkName = intent.getStringExtra("username")

        val trainingNames = deleteTrainingMappingC.getDeletableTrainings(clerkName)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, trainingNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        trainingSpinner.adapter = adapter

        deleteTrainingMappingButton.setOnClickListener {
            addTrainingMapping(clerkName)
        }
    }

    private fun addTrainingMapping(clerkName: String?) {
        val trainingName = trainingSpinner.selectedItem.toString()
        val errorMessage = deleteTrainingMappingC.deleteTrainingMapping(clerkName, trainingName)
        if (errorMessage == null) {
            Toast.makeText(this, "Training mapping removed successfully", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
