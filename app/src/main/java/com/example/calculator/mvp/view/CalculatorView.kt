package com.example.calculator.mvp.view

import android.app.Activity
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.mvp.view.base.ActivityView

class CalculatorView(activity: Activity, private val binding: ActivityMainBinding): ActivityView(activity), CalculatorContract.View {

    override fun setResult(result: String) {
        binding.textResult.text = result
    }
}
