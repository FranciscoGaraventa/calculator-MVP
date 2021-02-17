package com.example.calculator.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.mvp.model.CalculatorModel
import com.example.calculator.mvp.presenter.CalculatorPresenter
import com.example.calculator.mvp.view.CalculatorView

class CalculatorActivity : AppCompatActivity() {

    private lateinit var presenter: CalculatorPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = CalculatorPresenter(CalculatorModel(), CalculatorView(this, binding))
    }
}
