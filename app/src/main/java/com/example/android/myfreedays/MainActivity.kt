package com.example.android.myfreedays

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butSub.setOnClickListener {
            var days:Int = 0
            var userDOB = ""
            //get the date from teh field
            userDOB = editText.text.toString()
            var splitDOB = userDOB.split('/')

            //do the calcs
            var years = splitDOB[2].toInt()
            days += (Calendar.getInstance().get(Calendar.YEAR) - years) * 365

            var months = splitDOB[1].toInt()
            days += (Calendar.getInstance().get(Calendar.MONTH) - (months-1)) * 30

            var date = splitDOB[0].toInt()
            days += (Calendar.getInstance().get(Calendar.DATE) - date)


            // set the optext
            optext.setText("You have lived " + days.toString() + " days")

            //reset the input field
            editText.setText("")
        }
    }
}
