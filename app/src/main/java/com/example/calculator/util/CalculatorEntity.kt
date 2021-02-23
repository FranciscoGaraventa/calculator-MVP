package com.example.calculator.util

import java.io.Serializable

class CalculatorEntity(
    private var firstOperand: String,
    private var secondOperand: String,
    private var operator: String,
    private var enum: CalculatorEnum
) : Serializable {

    fun getFirstOperand(): String = firstOperand
    fun getSecondOperand(): String = secondOperand
    fun getOperator(): String = operator
    fun getEnum(): CalculatorEnum = enum

    fun setFirstOperand(firstOperand: String) {
        this.firstOperand = firstOperand
    }

    fun setSecondOperand(secondOperand: String) {
        this.secondOperand = secondOperand
    }

    fun setOperator(operator: String) {
        this.operator = operator
    }

    fun setEnum(enum: CalculatorEnum) {
        this.enum = enum
    }

    override fun toString(): String {
        return "$firstOperand$operator$secondOperand"
    }

    fun equals(otherEntity: CalculatorEntity): Boolean {
        return ((firstOperand == otherEntity.getFirstOperand()) && (secondOperand == otherEntity.getSecondOperand()) && (operator == otherEntity.getOperator()))
    }

}
