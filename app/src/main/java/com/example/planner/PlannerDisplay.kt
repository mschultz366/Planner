package com.example.planner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class PlannerDisplay : AppCompatActivity() {

    private var weekSelection = ""
    private var taskOne = ""
    private var taskOneChecked = true
    private var taskOneDuration = ""
    private var taskTwo = ""
    private var taskTwoChecked = true
    private var taskTwoDuration = ""
    private var taskThree = ""
    private var taskThreeChecked = true
    private var taskThreeDuration = ""
    private var taskFour = ""
    private var taskFourChecked = true
    private var taskFourDuration = ""
    private var taskFive = ""
    private var taskFiveChecked = true
    private var taskFiveDuration = ""
    private var taskSix = ""
    private var taskSixChecked = true
    private var taskSixDuration = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner_display)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val extras = intent.extras
        if(extras != null) {
            weekSelection = extras.getString("Weekday").toString()

            taskOne = extras.getString("Exercise").toString()
            taskOneDuration = extras.getString("ExerciseDuration").toString()
            taskOneChecked = extras.getString("taskOne").toBoolean()

            taskTwo = extras.getString("Work").toString()
            taskTwoDuration = extras.getString("WorkDuration").toString()
            taskTwoChecked = extras.getString("taskTwo").toBoolean()


            taskThree = extras.getString("Study").toString()
            taskThreeDuration = extras.getString("StudyDuration").toString()
            taskThreeChecked = extras.getString("taskThree").toBoolean()


            taskFour = extras.getString("WalkDog").toString()
            taskFourDuration = extras.getString("WalkDogDuration").toString()
            taskFourChecked = extras.getString("taskFour").toBoolean()


            taskFive = extras.getString("Relax").toString()
            taskFiveDuration = extras.getString("RelaxDuration").toString()
            taskFiveChecked = extras.getString("taskFive").toBoolean()


            taskSix = extras.getString("Clean").toString()
            taskSixDuration = extras.getString("CleanDuration").toString()
            taskSixChecked = extras.getString("taskSix").toBoolean()

        }

        val displayWeekday = findViewById<TextView>(R.id.hWeekday)
        displayWeekday.text = weekSelection

        val hTaskOne = findViewById<TextView>(R.id.displayTaskOne)
        val hTaskTwo = findViewById<TextView>(R.id.displayTaskTwo)
        val hTaskThree = findViewById<TextView>(R.id.displayTaskThree)
        val hTaskFour = findViewById<TextView>(R.id.displayTaskFour)
        val hTaskFive = findViewById<TextView>(R.id.displayTaskFive)
        val hTaskSix = findViewById<TextView>(R.id.displayTaskSix)

        val hdTaskOne = findViewById<TextView>(R.id.displayDurationOne)
        val hdTaskTwo = findViewById<TextView>(R.id.displayDurationTwo)
        val hdTaskThree = findViewById<TextView>(R.id.displayDurationThree)
        val hdTaskFour = findViewById<TextView>(R.id.displayDurationFour)
        val hdTaskFive = findViewById<TextView>(R.id.displayDurationFive)
        val hdTaskSix = findViewById<TextView>(R.id.displayDurationSix)

        val hdlProgress = findViewById<ProgressBar>(R.id.hProgress)

        val hCheckOne = findViewById<CheckBox>(R.id.checkOne)
        val hCheckTwo = findViewById<CheckBox>(R.id.checkTwo)
        val hCheckThree = findViewById<CheckBox>(R.id.checkThree)
        val hCheckFour = findViewById<CheckBox>(R.id.checkFour)
        val hCheckFive = findViewById<CheckBox>(R.id.checkFive)
        val hCheckSix = findViewById<CheckBox>(R.id.checkSix)

        val displayDebugTag = "Planner Display"

        if(taskOneChecked) {
            //Log.d(displayDebugTag, "True block $taskOneChecked")
            hTaskOne.text = taskOne
            hdTaskOne.text = taskOneDuration
        } else {
            //Log.d(displayDebugTag, "False block $taskOneChecked")
            hTaskOne.isVisible = false
            hdTaskOne.isVisible = false
            hCheckOne.isVisible = false
        }

        if(taskTwoChecked) {
            hTaskTwo.text = taskTwo
            hdTaskTwo.text = taskTwoDuration
        } else {
            hTaskTwo.isVisible = false
            hdTaskTwo.isVisible = false
            hCheckTwo.isVisible = false
        }

        if(taskThreeChecked) {
            hTaskThree.text = taskThree
            hdTaskThree.text = taskThreeDuration
        } else {
            hTaskThree.isVisible = false
            hdTaskThree.isVisible = false
            hCheckThree.isVisible = false
        }

        if(taskFourChecked) {
            hTaskFour.text = taskFour
            hdTaskFour.text = taskFourDuration
        } else {
            hTaskFour.isVisible = false
            hdTaskFour.isVisible = false
            hCheckFour.isVisible = false
        }

        if(taskFiveChecked) {
            hTaskFive.text = taskFive
            hdTaskFive.text = taskFiveDuration
        } else {
            hTaskFive.isVisible = false
            hdTaskFive.isVisible = false
            hCheckFive.isVisible = false
        }

        if(taskSixChecked) {
            hTaskSix.text = taskSix
            hdTaskSix.text = taskSixDuration
        } else {
            hTaskSix.isVisible = false
            hdTaskSix.isVisible = false
            hCheckSix.isVisible = false
        }

        val setTask: Array<Boolean> = arrayOf(taskOneChecked, taskTwoChecked, taskThreeChecked, taskFourChecked, taskFiveChecked, taskSixChecked)
        val boxes: Array<CheckBox> = arrayOf(hCheckOne, hCheckTwo, hCheckThree, hCheckFour, hCheckFive, hCheckSix)

        var progressBarMaxValue = 0

        for(check in setTask) {
            if(check) {
                progressBarMaxValue += 1
            }
        }

        hdlProgress.max = progressBarMaxValue

        for(box in boxes) {

            box.setOnClickListener {
                if(box.isChecked) {
                    hdlProgress.incrementProgressBy(1)
                }
                if(!box.isChecked) {
                    hdlProgress.incrementProgressBy(-1)
                }

                if(hdlProgress.progress == hdlProgress.max) {
                    Toast.makeText(applicationContext, getString(R.string.progress_max), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}