package com.example.calculator.mvp.contract

import com.example.calculator.util.CalculatorEntity

interface CalculatorContract {
    interface Presenter {
        fun onNumberButtonPressed(number: String)
        fun onOperationButtonPressed(operation: String)
        fun onDeletePressed()
        fun onClearPressed()
        fun onEqualButtonPressed()
        fun onResume(entity: CalculatorEntity)
        fun onSaveInstance(): CalculatorEntity
    }

    interface Model {
        fun onPressedNumber(number: String)
        fun onPressedOperation(operation: String)
        fun getResult(): String
        fun deleteCharacter()
        fun doEqualOperation()
        fun reset()
        fun getEntity(): CalculatorEntity
        fun setEntity(entity: CalculatorEntity)
    }

    interface View {
        fun setResult(result: String)
        fun showMessageError(error: String)
    }
}
