package com.example.septima.unitconverter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.widget.ImageButton

class ConverterPresenter(val view: ConverterView) {

    var converter:Int = 0

    private fun reset() {
        converter == 0
        updateCounter()
    }

    private fun updateCounter() {
        view.setConverter(converter)
    }

    fun start(){
        reset()
    }


}