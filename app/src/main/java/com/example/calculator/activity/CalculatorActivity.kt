package com.example.calculator.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.mvp.model.CalculatorModel
import com.example.calculator.mvp.presenter.CalculatorPresenter
import com.example.calculator.mvp.view.CalculatorView

class CalculatorActivity : AppCompatActivity() {

    private lateinit var presenter: CalculatorContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = CalculatorPresenter(CalculatorModel(), CalculatorView(this, binding))
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        setOnClickWithNumberTextButton(binding.buttonNumberZero)
        setOnClickWithNumberTextButton(binding.buttonNumberOne)
        setOnClickWithNumberTextButton(binding.buttonNumberTwo)
        setOnClickWithNumberTextButton(binding.buttonNumberThree)
        setOnClickWithNumberTextButton(binding.buttonNumberFour)
        setOnClickWithNumberTextButton(binding.buttonNumberFive)
        setOnClickWithNumberTextButton(binding.buttonNumberSix)
        setOnClickWithNumberTextButton(binding.buttonNumberSeven)
        setOnClickWithNumberTextButton(binding.buttonNumberEight)
        setOnClickWithNumberTextButton(binding.buttonNumberNine)
        binding.buttonClear.setOnClickListener {
            presenter.onClearPressed()
        }
        setOnClickWithOperatorTextButton(binding.buttonAdd)
        setOnClickWithOperatorTextButton(binding.buttonSubtraction)
        setOnClickWithOperatorTextButton(binding.buttonMultiplication)
        setOnClickWithOperatorTextButton(binding.buttonDivision)
        binding.buttonDelete.setOnClickListener {
            presenter.onDeletePressed()
        }
        binding.buttonEqual.setOnClickListener {
            presenter.onEqualButtonPressed()
        }
    }

    private fun setOnClickWithNumberTextButton(button: Button) {
        button.setOnClickListener { presenter.onNumberButtonPressed(button.text.toString()) }
    }

    private fun setOnClickWithOperatorTextButton(button: Button) {
        button.setOnClickListener { presenter.onOperationButtonPressed(button.text.toString()) }
    }
}
