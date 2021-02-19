package com.example.calculator.mvp.presenter

import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.util.CalculatorEntity

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
        view.setResult(model.getResult())
    }

    override fun onResume(entity: CalculatorEntity) {
        model.setEntity(entity)
        view.setResult(model.getResult())
    }

    override fun onSaveInstance(): CalculatorEntity = model.getEntity()

}
