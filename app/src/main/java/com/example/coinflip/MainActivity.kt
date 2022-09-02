package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.DataBindingUtil
import com.example.coinflip.databinding.ActivityMainBinding
import java.lang.Exception
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var heads = 0
    private var tails = 0
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // old way
        //setContentView(R.layout.activity_main)

        // new way..data binding way
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mainActivitySwSimulate.setOnCheckedChangeListener {
                compoundButton, isChecked -> enableSim(isChecked)
        }
        binding.mainActivityBtFlip.setOnClickListener { flip() }
        binding.mainActivityBtReset.setOnClickListener { reset() }
        binding.mainActivityBtSimulate.setOnClickListener { simulate() }

// old way not using data binding
//        simSwitch.setOnCheckedChangeListener { compoundButton, isChecked -> enableSim(isChecked) }
//        flipButton.setOnClickListener { flip() }
//        resetButton.setOnClickListener { reset() }
//        simButton.setOnClickListener { simulate() }
    }

    private fun enableSim(checked: Boolean) {
        if (checked) {
            binding.mainActivityEtSimulate.visibility = View.VISIBLE
            binding.mainActivityBtSimulate.visibility = View.VISIBLE
//            simEditText.visibility = View.VISIBLE
//            simButton.visibility = View.VISIBLE
        } else {
            binding.mainActivityEtSimulate.visibility = View.INVISIBLE
            binding.mainActivityBtSimulate.visibility = View.INVISIBLE
//            simEditText.visibility = View.INVISIBLE
//            simButton.visibility = View.INVISIBLE
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
            binding.mainActivityIvCoin.setImageResource(R.drawable.ic_head_icon)
            //coinImageView.setImageResource(R.drawable.ic_head_icon)
        } else {
            tails++
            binding.mainActivityIvCoin.setImageResource(R.drawable.ic_tail_icon)
            //coinImageView.setImageResource(R.drawable.ic_tail_icon)
        }
        total++

        binding.mainActivityTvTotalFlips.text = "Total Flips : $total"
        binding.mainActivityTvHeadFlips.text = "Total Heads : $heads"
        binding.mainActivityTvTailFlips.text = "Total Tails : $tails"
//        totalFlipText.text = "Total Flips : $total"
//        headFlipText.text = "Total Heads : $heads"
//        tailFlipText.text = "Total Tails : $tails"

        updateStatistics()
    }

    private fun updateStatistics() {
        var headsPercentResult = 0.0
        var tailsPercentResult = 0.0

        if (total != 0) {
            headsPercentResult = round((heads.toDouble() / total) * 100)
            tailsPercentResult = round((tails.toDouble() / total) * 100)
        }

//        headsPercentText.text = "Heads : $headsPercentResult%"
//        tailsPercentText.text = "Tails : $tailsPercentResult%"
        binding.mainActivityTvHeadsPercent.text = "Heads : $headsPercentResult%"
        binding.mainActivityTvTailsPercent.text = "Tails : $tailsPercentResult%"

//        headsProgressBar.progress = headsPercentResult.toInt()
//        tailsProgressBar.progress = tailsPercentResult.toInt()
        binding.mainActivityPbHead.progress = headsPercentResult.toInt()
        binding.mainActivityPbTail.progress = tailsPercentResult.toInt()
    }

    private fun reset() {
        heads = 0
        tails = 0
        total = 0

        // TODO
//        coinImageView.setImageResource(R.drawable.ic_flip_icon)
//        totalFlipText.text = "Total Flips : $total"
//        headFlipText.text = "Total Heads : $heads"
//        tailFlipText.text = "Total Tails : $tails"

        updateStatistics()
    }

    // TODO
    private fun simulate() {
//        var simNumber = 0
//        if (simulateEditText.text.toString() != "") {
//            simNumber = simulateEditText.text.toString().toInt()
//        }
//        // 먼저 sum number 가져온다.
//
//
//        for (i in 1..simNumber) {
//            flip()
//        }
//        simulateEditText.setText("")
    }


}