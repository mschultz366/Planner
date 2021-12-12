package com.example.planner

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch

class PlannerSetup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_setup)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val hdlWeekdaySpinner = findViewById<Spinner>(R.id.hWeekdaySpinner)

        val hdlTaskOne = findViewById<Switch>(R.id.hExercise)
        val hdlTaskTwo = findViewById<Switch>(R.id.hWork)
        val hdlTaskThree = findViewById<Switch>(R.id.hStudy)
        val hdlTaskFour = findViewById<Switch>(R.id.hWalkDog)
        val hdlTaskFive = findViewById<Switch>(R.id.hRelax)
        val hdlTaskSix = findViewById<Switch>(R.id.hClean)

        val hdlDurationOne = findViewById<EditText>(R.id.hDurationExercise)
        val hdlDurationTwo = findViewById<EditText>(R.id.hDurationWork)
        val hdlDurationThree = findViewById<EditText>(R.id.hDurationStudy)
        val hdlDurationFour = findViewById<EditText>(R.id.hDurationWalkDog)
        val hdlDurationFive = findViewById<EditText>(R.id.hDurationRelax)
        val hdlDurationSix = findViewById<EditText>(R.id.hDurationClean)

        val hdlSubmitButton = findViewById<Button>(R.id.hSubmitButton)

        var taskOneBoolean: Boolean = false
        var taskTwoBoolean: Boolean = false
        var taskThreeBoolean: Boolean = false
        var taskFourBoolean: Boolean = false
        var taskFiveBoolean: Boolean = false
        var taskSixBoolean: Boolean = false

        hdlTaskOne.setOnClickListener {
            taskOneBoolean = hdlTaskOne.isChecked
        }

        hdlTaskTwo.setOnCheckedChangeListener { _, isChecked ->
            taskTwoBoolean = hdlTaskTwo.isChecked
        }

        hdlTaskThree.setOnClickListener {
            taskThreeBoolean = hdlTaskThree.isChecked
        }

        hdlTaskFour.setOnClickListener {
            taskFourBoolean = hdlTaskFour.isChecked
        }

        hdlTaskFive.setOnClickListener {
            taskFiveBoolean = hdlTaskFive.isChecked
        }

        hdlTaskSix.setOnClickListener {
            taskSixBoolean = hdlTaskSix.isChecked
        }


        hdlSubmitButton.setOnClickListener {

            val displayScreen = Intent(this@PlannerSetup, PlannerDisplay::class.java).apply {

                putExtra("Weekday", hdlWeekdaySpinner.selectedItem.toString())

                putExtra("Exercise", hdlTaskOne.text)
                putExtra("ExerciseDuration", hdlDurationOne.text.toString())
                putExtra("taskOne", taskOneBoolean.toString())


                putExtra("Work", hdlTaskTwo.text.toString())
                putExtra("WorkDuration", hdlDurationTwo.text.toString())
                putExtra("taskTwo", taskTwoBoolean.toString())

                putExtra("Study", hdlTaskThree.text.toString())
                putExtra("StudyDuration", hdlDurationThree.text.toString())
                putExtra("taskThree", taskThreeBoolean.toString())

                putExtra("WalkDog", hdlTaskFour.text.toString())
                putExtra("WalkDogDuration", hdlDurationFour.text.toString())
                putExtra("taskFour", taskFourBoolean.toString())

                putExtra("Relax", hdlTaskFive.text.toString())
                putExtra("RelaxDuration", hdlDurationFive.text.toString())
                putExtra("taskFive", taskFiveBoolean.toString())

                putExtra("Clean", hdlTaskSix.text.toString())
                putExtra("CleanDuration", hdlDurationSix.text.toString())
                putExtra("taskSix", taskSixBoolean.toString())

            }
            startActivity(displayScreen)
        }
    }
}