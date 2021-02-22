package com.example.calculator.mvp.model

import com.example.calculator.util.Constants.DIV
import com.example.calculator.util.Constants.PLUS
import com.example.calculator.util.Constants.ZERO
import com.example.calculator.util.Constants.EMPTY
import com.example.calculator.util.Constants.MINUS
import com.example.calculator.util.Constants.TIMES
import com.example.calculator.util.CalculatorEntity
import com.example.calculator.mvp.contract.CalculatorContract

class CalculatorModel : CalculatorContract.Model {

    private var entity: CalculatorEntity = CalculatorEntity(ZERO, EMPTY, EMPTY)

    private fun isResultZero(): Boolean{
        return (entity.getOperator().isEmpty() && entity.getFirstOperand() == ZERO)
    }

    override fun onPressedNumber(number: String) {
        if (isResultZero()) {
            entity.setFirstOperand(number)
        } else {
            if (entity.getOperator().isEmpty()) {
                entity.setFirstOperand(entity.getFirstOperand().plus(number))
            } else {
                entity.setSecondOperand(entity.getSecondOperand().plus(number))
            }
        }
    }

    override fun onPressedOperation(operation: String) {
        entity.setOperator(operation)
    }

    override fun getResult(): String = entity.toString()

    override fun deleteCharacter() {
        if (entity.getSecondOperand().isNotEmpty()) {
            entity.setSecondOperand(entity.getSecondOperand().substring(0, entity.getSecondOperand().length - 1))
        } else {
            if (entity.getOperator().isNotEmpty()) {
                entity.setOperator(EMPTY)
            } else {
                if (entity.getFirstOperand().isNotEmpty()) {
                    entity.setFirstOperand(entity.getFirstOperand().substring(0, entity.getFirstOperand().length - 1))
                }
                if (entity.getFirstOperand().isEmpty()) entity.setFirstOperand(ZERO)
            }
        }
    }

    override fun doEqualOperation() {
        when (entity.getOperator()) {
            PLUS -> entity.setFirstOperand((entity.getFirstOperand().toInt().plus(entity.getSecondOperand().toInt())).toString())
            MINUS -> entity.setFirstOperand((entity.getFirstOperand().toInt().minus(entity.getSecondOperand().toInt())).toString())
            TIMES -> entity.setFirstOperand((entity.getFirstOperand().toInt().times(entity.getSecondOperand().toInt())).toString())
            DIV -> entity.setFirstOperand((entity.getFirstOperand().toInt().div(entity.getSecondOperand().toInt())).toString())
        }
        entity.setOperator(EMPTY)
        entity.setSecondOperand(EMPTY)
    }

    override fun reset() {
        entity.setFirstOperand(ZERO)
        entity.setSecondOperand(EMPTY)
        entity.setOperator(EMPTY)
    }

    override fun getEntity(): CalculatorEntity = entity

    override fun setEntity(entity: CalculatorEntity) {
        this.entity.setFirstOperand(entity.getFirstOperand())
        this.entity.setSecondOperand(entity.getSecondOperand())
        this.entity.setOperator(entity.getOperator())
    }

}
