package com.tim.trainingmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.tim.trainingmanagement.R
import com.tim.trainingmanagement.util.WithSelectorActivity

class UserActivity : WithSelectorActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userview)

        val editUserButton: Button = findViewById(R.id.edit_user_button)
        val showTrainingMappingButton: Button = findViewById(R.id.show_training_mapping_button)
        val addTrainingMappingButton: Button = findViewById(R.id.add_training_mapping_button)
        val deleteTrainingMappingButton : Button = findViewById(R.id.delete_training_mapping_button)
        val logoutButton: Button = findViewById(R.id.logout_button)


        val editUserLauncher = getUserNameLauncher(EditUserActivity::class.java)

        editUserButton.setOnClickListener {
            val intent = Intent(this, UserSelectorActivity::class.java)
            intent.putExtra("isAdmin", false)
            editUserLauncher.launch(intent)
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
            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
            finish()
        }
    }
}
