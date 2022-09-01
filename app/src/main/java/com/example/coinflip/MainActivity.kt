package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SwitchCompat
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var simEditText: EditText
    private lateinit var simButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simSwitch: SwitchCompat = findViewById(R.id.main_activity_sw_simulate)
        val flipButton: Button = findViewById(R.id.main_activity_bt_flip)
        val resetButton: Button = findViewById(R.id.main_activity_bt_reset)
        simButton = findViewById(R.id.main_activity_bt_simulate)
        simEditText = findViewById(R.id.main_activity_et_simulate)

        simSwitch.setOnCheckedChangeListener { compoundButton, isChecked -> enableSim(isChecked) }
        flipButton.setOnClickListener { flip() }
        resetButton.setOnClickListener { reset() }
        simButton.setOnClickListener { simulate() }
    }

    private fun enableSim(checked: Boolean) {
        if (checked) {
            simEditText.visibility = View.VISIBLE
            simButton.visibility = View.VISIBLE
        } else {
            simEditText.visibility = View.INVISIBLE
            simButton.visibility = View.INVISIBLE
        }
    }

    private fun flip() {

    }

    private fun reset() {

    }

    private fun simulate() {

    }


}