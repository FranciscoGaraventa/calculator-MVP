package com.example.calculator.util

import java.io.Serializable

class CalculatorEntity(private var firstOperand: String, private var secondOperand: String, private var operator: String) : Serializable {

    fun getFirstOperand(): String = firstOperand
    fun getSecondOperand(): String = secondOperand
    fun getOperator(): String = operator

    fun setFirstOperand(firstOperand: String){this.firstOperand = firstOperand}
    fun setSecondOperand(secondOperand: String){this.secondOperand = secondOperand}
    fun setOperator(operator: String){this.operator = operator}

    override fun toString(): String {
        return "$firstOperand$operator$secondOperand"
    }

}
