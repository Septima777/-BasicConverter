package com.example.septima.unitconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.example.septima.unitconverter.R.id.tempBtn
import com.example.septima.unitconverter.R.id.timeButton


class MainActivity : AppCompatActivity(), ConverterView {
    override fun setConverter(value: Int) {    }

    lateinit var presenter : ConverterPresenter
    lateinit var timeBtn : ImageButton
    lateinit var tempBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeBtn = findViewById<ImageButton>(R.id.timeButton)
        tempBtn = findViewById<ImageButton>(R.id.tempButton)
        presenter = ConverterPresenter(this)
        presenter.start()
    }



    fun goToTimeActivity(view: View) {
        timeBtn.setOnClickListener {
            val intent = Intent(this, MaintimeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity,"Time selected", Toast.LENGTH_LONG).show()
        }
    }

    fun goToTempActivity(view: View) {
        tempBtn.setOnClickListener{
            val intent = Intent(this, MaintempActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity, "Temperature selected",Toast.LENGTH_LONG).show()
        }

    }

}
