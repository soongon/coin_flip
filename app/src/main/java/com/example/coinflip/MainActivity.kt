package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import java.lang.Exception
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var simEditText: EditText
    private lateinit var simButton: Button
    private lateinit var coinImageView: ImageView
    private lateinit var totalFlipText: TextView
    private lateinit var headFlipText: TextView
    private lateinit var tailFlipText: TextView
    private lateinit var headsPercentText: TextView
    private lateinit var tailsPercentText: TextView
    private lateinit var headsProgressBar: ProgressBar
    private lateinit var tailsProgressBar: ProgressBar

    private var heads = 0
    private var tails = 0
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simSwitch: SwitchCompat = findViewById(R.id.main_activity_sw_simulate)
        val flipButton: Button = findViewById(R.id.main_activity_bt_flip)
        val resetButton: Button = findViewById(R.id.main_activity_bt_reset)
        simButton = findViewById(R.id.main_activity_bt_simulate)
        simEditText = findViewById(R.id.main_activity_et_simulate)
        coinImageView = findViewById(R.id.main_activity_iv_coin)
        totalFlipText = findViewById(R.id.main_activity_tv_total_flips)
        headFlipText = findViewById(R.id.main_activity_tv_head_flips)
        tailFlipText = findViewById(R.id.main_activity_tv_tail_flips)
        headsPercentText = findViewById(R.id.main_activity_tv_heads_percent)
        tailsPercentText = findViewById(R.id.main_activity_tv_tails_percent)
        headsProgressBar = findViewById(R.id.main_activity_pb_head)
        tailsProgressBar = findViewById(R.id.main_activity_pb_tail)

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

        val randomNumber = (0..1).random()
        // 0..head, 1..tail
        if (randomNumber == 0) {
            update("heads")
        } else {
            update("tails")
        }
    }
    private fun update(coinValue: String) {
        if (coinValue == "heads") {
            heads++
            coinImageView.setImageResource(R.drawable.ic_head_icon)
        } else {
            tails++
            coinImageView.setImageResource(R.drawable.ic_tail_icon)
        }
        total++

        totalFlipText.text = "Total Flips : $total"
        headFlipText.text = "Total Heads : $heads"
        tailFlipText.text = "Total Tails : $tails"

        updateStatistics()
    }

    private fun updateStatistics() {
        var headsPercentResult = 0.0
        var tailsPercentResult = 0.0

        if (total != 0) {
            headsPercentResult = round((heads.toDouble() / total) * 100)
            tailsPercentResult = round((tails.toDouble() / total) * 100)
        }

        headsPercentText.text = "Heads : $headsPercentResult%"
        tailsPercentText.text = "Tails : $tailsPercentResult%"

        headsProgressBar.progress = headsPercentResult.toInt()
        tailsProgressBar.progress = tailsPercentResult.toInt()
    }

    private fun reset() {
        heads = 0
        tails = 0
        total = 0
        coinImageView.setImageResource(R.drawable.ic_flip_icon)
        totalFlipText.text = "Total Flips : $total"
        headFlipText.text = "Total Heads : $heads"
        tailFlipText.text = "Total Tails : $tails"

        updateStatistics()
    }

    private fun simulate() {

    }


}