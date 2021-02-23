package com.example.calculator.mvp.presenter

import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.util.CalculatorEntity
import com.example.calculator.util.CalculatorEnum
import com.example.calculator.util.Constants.DIVISION_BY_ZERO_MSG
import com.example.calculator.util.Constants.INCOMPLETE_OPERATION_MSG
import com.example.calculator.util.Constants.INVALID_NUMBER_MSG

class CalculatorPresenter(private val model: CalculatorContract.Model, private val view: CalculatorContract.View) :
    CalculatorContract.Presenter {

    override fun onNumberButtonPressed(number: String) {
        model.onPressedNumber(number)
        view.setResult(model.getResult())
    }

    override fun onOperationButtonPressed(operation: String) {
        model.onPressedOperation(operation)
        view.setResult(model.getResult())
    }

    override fun onDeletePressed() {
        model.deleteCharacter()
        view.setResult(model.getResult())
    }

    override fun onClearPressed() {
        model.reset()
        view.setResult(model.getResult())
    }

    override fun onEqualButtonPressed() {
        model.doEqualOperation()
        when (model.getEntity().getEnum()) {
            CalculatorEnum.SUCCESS -> view.setResult(model.getResult())
            CalculatorEnum.INCOMPLETE_OPERATION -> view.showMessageError(INCOMPLETE_OPERATION_MSG)
            CalculatorEnum.DIVISION_BY_ZERO -> view.showMessageError(DIVISION_BY_ZERO_MSG)
            CalculatorEnum.INVALID_NUMBER -> view.showMessageError(INVALID_NUMBER_MSG)
        }
    }

    override fun onResume(entity: CalculatorEntity) {
        model.setEntity(entity)
        view.setResult(model.getResult())
    }

    override fun onSaveInstance(): CalculatorEntity = model.getEntity()

}
