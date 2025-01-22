package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.control.ExampleDeleteTrainingMappingC
import com.tim.trainingmanagement.control.ExampleShowTrainingMappingC

class ShowTrainingMappingActivity : AppCompatActivity() {

    private lateinit var trainingListView: ListView
    private val showTrainingMappingC = ExampleShowTrainingMappingC()
    private val deleteTrainingMappingC = ExampleDeleteTrainingMappingC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_training_mapping_view)

        trainingListView = findViewById(R.id.training_list_view)

        val username = intent.getStringExtra("username")
        if (username != null) {
            val attendedTrainings = showTrainingMappingC.getAttendedTrainingNames(username)
            val completedTrainings = showTrainingMappingC.getCompletedTrainingNames(username)
            val trainingList = attendedTrainings.toList() + completedTrainings.toList()

            val adapter = TrainingListAdapter(this, trainingList)
            trainingListView.adapter = adapter

            trainingListView.setOnItemClickListener { _, _, position, _ ->
                val trainingName = trainingList[position]
                val errorMessage = deleteTrainingMappingC.deleteTrainingMapping(username, trainingName)
                if (errorMessage == null) {
                    Toast.makeText(this, "Training mapping deleted successfully", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "No user selected", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
