package com.example.septima.unitconverter

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MaintimeActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    var fromTime : EditText = findViewById(R.id.fromTime)
    var toTime : EditText = findViewById(R.id.toTime)
    var spinFromBox : Spinner = findViewById(R.id.fromBox)
    var spinToBox :  Spinner = findViewById(R.id.toBox)
    var spinnerArray = arrayOf("Seconds", "Minutes", "Hours")
    var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maintime)
        fromTimeType()
        toTimeType()
    }

    fun fromTimeType(){
        val spinnerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinFromBox.adapter = spinnerArrayAdapter
        spinFromBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                Toast.makeText(this@MaintimeActivity,spinFromBox.selectedItem.toString(),Toast.LENGTH_LONG).show()
            }

        }

    }

    fun toTimeType(){
        val spinnerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinToBox.adapter = spinnerArrayAdapter
        spinToBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                Toast.makeText(this@MaintimeActivity,spinToBox.selectedItem.toString(),Toast.LENGTH_LONG).show()
            }

        }

    }

    fun convertTime(view: View){
        if(spinFromBox.selectedItem.toString().equals("Seconds")){
            if(spinToBox.selectedItem.toString().equals("Minutes")){
                var editTime = fromTime.getText().toString()
                var fromTimeValue = Integer.parseInt(editTime)
                value = fromTimeValue/60
                toTime.setText(value)

            }else if (spinToBox.selectedItem.toString().equals("Hours")){
                var editTime = fromTime.getText().toString()
                var fromTimeValue = Integer.parseInt(editTime)
                value = fromTimeValue/3600
                toTime.setText(value)
            }
        }else if(spinFromBox.selectedItem.toString().equals("Minutes")){
            if(spinToBox.selectedItem.toString().equals("Seconds")){
                var editTime = fromTime.getText().toString()
                var fromTimeValue = Integer.parseInt(editTime)
                value = fromTimeValue*60
                toTime.setText(value)

            }else if (spinToBox.selectedItem.toString().equals("Hours")){
                var editTime = fromTime.getText().toString()
                var fromTimeValue = Integer.parseInt(editTime)
                value = fromTimeValue/60
                toTime.setText(value)
            }
        }else if(spinFromBox.selectedItem.toString().equals("Hours")){
            if(spinToBox.selectedItem.toString().equals("Minutes")){
                var editTime = fromTime.getText().toString()
                var fromTimeValue = Integer.parseInt(editTime)
                value = fromTimeValue*60
                toTime.setText(value)

            }else if (spinToBox.selectedItem.toString().equals("Seconds")){
                var editTime = fromTime.getText().toString()
                var fromTimeValue = Integer.parseInt(editTime)
                value = fromTimeValue*3600
                toTime.setText(value)
            }
        }
    }


}
