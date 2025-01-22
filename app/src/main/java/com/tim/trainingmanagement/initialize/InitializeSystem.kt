package com.tim.trainingmanagement.initialize

import com.tim.trainingmanagement.entity.Clerk
import com.tim.trainingmanagement.entity.Training


fun setupClerks() {
    val adminClerk = Clerk("admin", "password1234$", true)
    val userClerk = Clerk("user", "password1234$", false)
    Clerk.addClerk(adminClerk)
    Clerk.addClerk(userClerk)
}


fun setupTrainings() {
    val maths1 = Training(mutableSetOf(), "Maths 1")
    Training.addTraining(maths1)

    val maths2 = Training(setOf(maths1), "Maths 2")
    Training.addTraining(maths2)

    val business = Training(mutableSetOf(), "Business")
    Training.addTraining(business)

    val costCalculation = Training(setOf(maths1, business), "Cost Calculation")
    Training.addTraining(costCalculation)
}