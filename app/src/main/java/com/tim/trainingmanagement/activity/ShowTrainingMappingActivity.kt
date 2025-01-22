package com.tim.trainingmanagement.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.adapter.TrainingListAdapter
import com.tim.trainingmanagement.control.ExampleDeleteTrainingMappingC
import com.tim.trainingmanagement.control.ExampleShowTrainingMappingC

class ShowTrainingMappingActivity : AppCompatActivity() {

    private lateinit var trainingRecyclerView: RecyclerView
    private val showTrainingMappingC = ExampleShowTrainingMappingC()
    private val deleteTrainingMappingC = ExampleDeleteTrainingMappingC()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_training_mapping_view)

        trainingRecyclerView = findViewById(R.id.training_list_view)
        trainingRecyclerView.layoutManager = LinearLayoutManager(this)

        val username = intent.getStringExtra("username")
        if (username != null) {
            val attendedTrainings = showTrainingMappingC.getAttendedTrainingNames(username)
            val completedTrainings = showTrainingMappingC.getCompletedTrainingNames(username)
            val trainingList = attendedTrainings.toList() + completedTrainings.toList()

            val adapter = TrainingListAdapter(this, trainingList)
            trainingRecyclerView.adapter = adapter
        } else {
            Toast.makeText(this, "No user selected", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}