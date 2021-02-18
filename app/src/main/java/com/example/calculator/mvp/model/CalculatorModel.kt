package com.example.calculator.mvp.model

import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.util.Constants.DIV
import com.example.calculator.util.Constants.EMPTY
import com.example.calculator.util.Constants.MINUS
import com.example.calculator.util.Constants.PLUS
import com.example.calculator.util.Constants.TIMES
import com.example.calculator.util.Constants.ZERO

class CalculatorModel : CalculatorContract.Model {

    private var firstOperand = EMPTY
    private var secondOperand = EMPTY
    private var operator = EMPTY

    private fun isResultZero(): Boolean{
        return (operator.isEmpty() && firstOperand == ZERO)
    }

    override fun onPressedNumber(number: String) {
        if (isResultZero()) {
            firstOperand = number
        } else {
            if (operator.isEmpty()) {
                firstOperand = firstOperand.plus(number)
            } else {
                secondOperand = secondOperand.plus(number)
            }
        }
    }

    override fun onPressedOperation(operation: String) {
        operator = operation
    }

    override fun getResult(): String = "$firstOperand$operator$secondOperand"

    override fun deleteCharacter() {
        if (secondOperand.isNotEmpty()) {
            secondOperand = secondOperand.substring(0, secondOperand.length - 1)
        } else {
            if (operator.isNotEmpty()) {
                operator = EMPTY
            } else {
                if (firstOperand.isNotEmpty()) {
                    firstOperand = firstOperand.substring(0, firstOperand.length - 1)
                }
                if (firstOperand.isEmpty()) firstOperand = ZERO
            }
        }
    }

    override fun doEqualOperation() {
        when (operator) {
            PLUS -> firstOperand = (firstOperand.toInt().plus(secondOperand.toInt())).toString()
            MINUS -> firstOperand = (firstOperand.toInt().minus(secondOperand.toInt())).toString()
            TIMES -> firstOperand = (firstOperand.toInt().times(secondOperand.toInt())).toString()
            DIV -> firstOperand = (firstOperand.toInt().div(secondOperand.toInt())).toString()
        }
        operator = EMPTY
        secondOperand = EMPTY
    }

    override fun reset() {
        firstOperand = ZERO
        secondOperand = EMPTY
        operator = EMPTY
    }

}
