package com.example.edittextplusbutton


import android.app.ActionBar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

     private var name: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
         name = findViewById(R.id.editText)


        button.setOnClickListener {


            val textView1 = EditText(this)
            textView1.layoutParams = ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )

            textView1.hint = "Enter Your Data"

            textView1.setPadding(300, 25, 300, 25) // in pixels (left, top, right, bottom)

            linearLayout.addView(textView1)


        }

    }
    override fun onResume() {
        super.onResume()

        // Fetching the stored data
        // from the SharedPreference
        val sh = getSharedPreferences("My", MODE_PRIVATE)
        val s1 = sh.getString("name", "")


        // Setting the fetched data
        // in the EditTexts
        name!!.setText(s1)

    }

    override fun onPause() {
        super.onPause()

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        val sharedPreferences = getSharedPreferences("My", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name!!.text.toString())
        myEdit.apply()
    }



}