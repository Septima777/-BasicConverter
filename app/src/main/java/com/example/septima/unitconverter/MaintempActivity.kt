package com.example.septima.unitconverter

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MaintempActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    var fromTemp : EditText = findViewById(R.id.fromTemp)
    var toTemp : EditText = findViewById(R.id.toTemp)
    var spinFromBox : Spinner = findViewById(R.id.fromBox)
    var spinToBox : Spinner = findViewById(R.id.toBox)
    var spinnerArray = arrayOf("Celsius", "Fahrenheit", "Kelvin")
    var tempValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maintemp)
        fromTempType()
        toTempType()
    }

    fun fromTempType(){
        val spinnerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinFromBox.adapter = spinnerArrayAdapter
        spinFromBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                Toast.makeText(this@MaintempActivity,spinFromBox.selectedItem.toString(), Toast.LENGTH_LONG).show()
            }

        }
    }

    fun toTempType(){
        val spinnerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinToBox.adapter = spinnerArrayAdapter
        spinToBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                Toast.makeText(this@MaintempActivity,spinToBox.selectedItem.toString(), Toast.LENGTH_LONG).show()
            }

        }
    }

    fun convertTemp(view: View) {
        if(spinFromBox.selectedItem.toString().equals("Celsius")){
            if(spinToBox.selectedItem.toString().equals("Fahrenheit")){
                var editTemp = fromTemp.getText().toString()
                var fromTempValue = Integer.parseInt(editTemp)
                tempValue = fromTempValue*(9/5)+32.toInt()
                toTemp.setText(tempValue)

            }else if (spinToBox.selectedItem.toString().equals("Kelvin")){
                var editTemp = fromTemp.getText().toString()
                var fromTempValue = Integer.parseInt(editTemp)
                tempValue = (fromTempValue + 273.15).toInt()
                toTemp.setText(tempValue)
            }
        }else if(spinFromBox.selectedItem.toString().equals("Fahrenheit")){
            if(spinToBox.selectedItem.toString().equals("Celsius")){
                var editTemp = fromTemp.getText().toString()
                var fromTempValue = Integer.parseInt(editTemp)
                tempValue = ((fromTempValue-32)/1.8).toInt()
                toTemp.setText(tempValue)

            }else if (spinToBox.selectedItem.toString().equals("Kelvin")){
                var editTemp = fromTemp.getText().toString()
                var fromTempValue = Integer.parseInt(editTemp)
                tempValue = ((fromTempValue + 459.67)*(5/9)).toInt()
                toTemp.setText(tempValue)
            }
        }else if(spinFromBox.selectedItem.toString().equals("Kelvin")){
            if(spinToBox.selectedItem.toString().equals("Celsius")){
                var editTemp = fromTemp.getText().toString()
                var fromTempValue = Integer.parseInt(editTemp)
                tempValue = (fromTempValue-273.15).toInt()
                toTemp.setText(tempValue)

            }else if (spinToBox.selectedItem.toString().equals("Fahrenheit")){
                var editTemp = fromTemp.getText().toString()
                var fromTempValue = Integer.parseInt(editTemp)
                tempValue = (fromTempValue*(9/5)-459.67).toInt()
                toTemp.setText(tempValue)
            }
        }
    }
}
