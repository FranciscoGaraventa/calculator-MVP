package com.example.calculator.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.util.CalculatorEntity
import com.example.calculator.mvp.view.CalculatorView
import com.example.calculator.mvp.model.CalculatorModel
import com.example.calculator.util.Constants.OPERATOR
import com.example.calculator.util.Constants.FIRST_OPERAND
import com.example.calculator.util.Constants.SECOND_OPERAND
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.mvp.presenter.CalculatorPresenter
import com.example.calculator.util.CalculatorEnum
import com.example.calculator.util.Constants.ENUM

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(FIRST_OPERAND, presenter.onSaveInstance().getFirstOperand())
        outState.putSerializable(SECOND_OPERAND, presenter.onSaveInstance().getSecondOperand())
        outState.putSerializable(OPERATOR, presenter.onSaveInstance().getOperator())
        outState.putSerializable(ENUM, presenter.onSaveInstance().getEnum())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.onResume(
            CalculatorEntity(
                savedInstanceState.get(FIRST_OPERAND).toString(),
                savedInstanceState.get(SECOND_OPERAND).toString(),
                savedInstanceState.get(OPERATOR).toString(),
                CalculatorEnum.valueOf(savedInstanceState.get(ENUM).toString())
            )
        )
    }

    private fun setOnClickWithNumberTextButton(button: Button) {
        button.setOnClickListener { presenter.onNumberButtonPressed(button.text.toString()) }
    }

    private fun setOnClickWithOperatorTextButton(button: Button) {
        button.setOnClickListener { presenter.onOperationButtonPressed(button.text.toString()) }
    }
}
