package com.tim.trainingmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tim.trainingmanagement.R

class AdminActivity: AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.adminview)

        val createUserButton: Button = findViewById(R.id.create_user_button)
        val editUserButton: Button = findViewById(R.id.edit_user_button)
        val deleteUserButton: Button = findViewById(R.id.delete_user_button)
        val mapTrainingButton: Button = findViewById(R.id.map_training_button)
        val showUserTrainingsButton: Button = findViewById(R.id.show_user_trainings_button)

    }
}
