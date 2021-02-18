package com.example.calculator.mvp.contract

interface CalculatorContract {
    interface Presenter{
        fun onNumberButtonPressed(number: String)
        fun onOperationButtonPressed(operation: String)
        fun onDeletePressed()
        fun onClearPressed()
        fun onEqualButtonPressed()
    }

    interface Model{
        fun onPressedNumber(number: String)
        fun onPressedOperation(operation: String)
        fun getResult(): String
        fun deleteCharacter()
        fun doEqualOperation()
        fun reset()
    }

    interface View{
        fun setResult(result: String)
    }
}
