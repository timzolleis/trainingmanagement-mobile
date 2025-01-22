package com.tim.trainingmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.util.WithSelectorActivity

class Admin : WithSelectorActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adminview)

        val createUserButton: Button = findViewById(R.id.create_user_button)
        val editUserButton: Button = findViewById(R.id.edit_user_button)
        val deleteUserButton: Button = findViewById(R.id.delete_user_button)
        val mapTrainingButton: Button = findViewById(R.id.map_training_button)
        val showUserTrainingsButton: Button = findViewById(R.id.show_user_trainings_button)


        createUserButton.setOnClickListener {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }

        val editUserLauncher = getUserNameLauncher(EditUserActivity::class.java)

        editUserButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            editUserLauncher.launch(intent)
        }

        val deleteUserLauncher = getUserNameLauncher(DeleteUserActivity::class.java)
        deleteUserButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            deleteUserLauncher.launch(intent)
        }
    }
}