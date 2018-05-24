package com.example.septima.unitconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import com.example.septima.unitconverter.R.id.tempBtn
import com.example.septima.unitconverter.R.id.timeButton


class MainActivity : AppCompatActivity(), ConverterView {
    override fun setConverter(value: Int) {    }

    lateinit var presenter : ConverterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ConverterPresenter(this)
        presenter.start()
    }

    var timeBtn = findViewById<ImageButton>(R.id.timeButton)
    var tempBtn = findViewById<ImageButton>(R.id.tempButton)

    fun goToTimeActivity(view: View) {
        timeBtn.setOnClickListener {
            val intent = Intent(this, MaintimeActivity::class.java)
            startActivity(intent)
        }
    }

    fun goToTempActivity(view: View) {
        tempBtn.setOnClickListener{
            val intent = Intent(this, MaintempActivity::class.java)
            startActivity(intent)
        }

    }

}
