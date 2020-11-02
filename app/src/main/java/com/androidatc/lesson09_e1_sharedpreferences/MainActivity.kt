package com.androidatc.lesson09_e1_sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREF_Name = "myPrefs"
    var myPref: SharedPreferences?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {
            myPref = getSharedPreferences(PREF_Name, 0)

            // 0 => private
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()

            // ! => exclamation mark with IF statement means NOT
            if (!TextUtils.isEmpty(enterNameID.text.toString())) {

                // "message" is the key and "enterNameID" content is the value
                // Add value using putString() method
                editor.putString("message", enterNameID.text.toString())

                // returns the value which is "enterNameID" content
                editor.commit()
            }
            // if the "enterNameID" is empty, the below Toast message will appear
            else {
                Toast.makeText(this, "Please Enter Your First Name", Toast.LENGTH_LONG).show()
            }
        }

            // Get Data Back
            var databack: SharedPreferences = getSharedPreferences(PREF_Name,0)

            if (databack.contains("message")) {
                result.text = databack.getString("message","not found")
        }
    }
}
