package com.tim.trainingmanagement.util

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

abstract class WithSelectorActivity: AppCompatActivity() {

    public fun <T> getUserNameLauncher(targetActivity: Class<T>): ActivityResultLauncher<Intent> {
        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val username = result.data?.getStringExtra("username")
                if (username != null) {
                    val intent = Intent(this, targetActivity)
                    intent.putExtra("username", username)
                    result.data?.extras?.let { extras ->
                        for (key in extras.keySet()) {
                            val value = extras.get(key)
                            when (value) {
                                is String -> intent.putExtra(key, value)
                                is Int -> intent.putExtra(key, value)
                                is Boolean -> intent.putExtra(key, value)
                            }
                        }
                    }
                    startActivity(intent)
                }
            }
        }
    }

}