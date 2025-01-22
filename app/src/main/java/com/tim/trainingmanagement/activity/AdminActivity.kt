package com.tim.trainingmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.util.WithSelectorActivity

class AdminActivity : WithSelectorActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adminview)

        val createUserButton: Button = findViewById(R.id.create_user_button)
        val editUserButton: Button = findViewById(R.id.edit_user_button)
        val deleteUserButton: Button = findViewById(R.id.delete_user_button)
        val showTrainingMappingButton: Button = findViewById(R.id.show_training_mapping_button)
        val addTrainingMappingButton: Button = findViewById(R.id.add_training_mapping_button)
        val deleteTrainingMappingButton : Button = findViewById(R.id.delete_training_mapping_button)
        val logoutButton: Button = findViewById(R.id.logout_button)


        createUserButton.setOnClickListener {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }

        val editUserLauncher = getUserNameLauncher(EditUserActivity::class.java)

        editUserButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            intent.putExtra("isAdmin", true)
            editUserLauncher.launch(intent)
        }

        val deleteUserLauncher = getUserNameLauncher(DeleteUserActivity::class.java)
        deleteUserButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            deleteUserLauncher.launch(intent)
        }

        val mapTrainingLauncher = getUserNameLauncher(ShowTrainingMappingActivity::class.java)
        showTrainingMappingButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            mapTrainingLauncher.launch(intent)
        }

        val addTrainingMappingLauncher = getUserNameLauncher(AddTrainingMappingActivity::class.java)
        addTrainingMappingButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            addTrainingMappingLauncher.launch(intent)
        }

        val removeTrainingMappingLauncher = getUserNameLauncher(DeleteTrainingMappingActivity::class.java)
        deleteTrainingMappingButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            removeTrainingMappingLauncher.launch(intent)
        }

        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
