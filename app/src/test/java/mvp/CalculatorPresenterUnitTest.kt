package mvp

import com.example.calculator.mvp.contract.CalculatorContract
import com.example.calculator.mvp.model.CalculatorModel
import com.example.calculator.mvp.presenter.CalculatorPresenter
import com.example.calculator.util.CalculatorEntity
import com.example.calculator.util.Constants.DIV
import com.example.calculator.util.Constants.EMPTY
import com.example.calculator.util.Constants.MINUS
import com.example.calculator.util.Constants.PLUS
import com.example.calculator.util.Constants.TIMES
import com.example.calculator.util.Constants.ZERO
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorPresenterUnitTest {
    private lateinit var presenter: CalculatorContract.Presenter
    private val model: CalculatorContract.Model = CalculatorModel()
    private val view: CalculatorContract.View = mock()

    companion object {
        const val ADD_RESULT = "15"
        const val MINUS_RESULT = "5"
        const val DIV_RESULT = "3.34"
        const val TIMES_RESULT = "30"
        const val NEGATIVE_ADD_RESULT = "-1"
        const val DELETE_RESULT = "10-5"
        const val NUMBER_TEN = "10"
        const val NUMBER_FIVE = "5"
        const val NUMBER_THREE = "3"
        const val NEGATIVE_FOUR = "-4"
        const val NUMBER_FIFTY_TWO = "52"
    }

    @Before
    fun setUp() {
        model.setEntity(CalculatorEntity(ZERO, EMPTY, EMPTY))
        presenter = CalculatorPresenter(model, view)
    }

    @Test
    fun `checked correct plus operation and showing the result value in view`() {
        model.getEntity().setFirstOperand(NUMBER_TEN)
        model.getEntity().setOperator(PLUS)
        model.getEntity().setSecondOperand(NUMBER_FIVE)
        presenter.onEqualButtonPressed()
        assertEquals(ADD_RESULT, model.getEntity().getFirstOperand())
        verify(view).setResult(ADD_RESULT)
    }

    @Test
    fun `checked correct substraction operation and showing the result value in view`() {
        model.getEntity().setFirstOperand(NUMBER_TEN)
        model.getEntity().setOperator(MINUS)
        model.getEntity().setSecondOperand(NUMBER_FIVE)
        presenter.onEqualButtonPressed()
        assertEquals(MINUS_RESULT, model.getEntity().getFirstOperand())
        verify(view).setResult(MINUS_RESULT)
    }

    @Test
    fun `checked correct division operation and showing the result value in view`() {
        model.getEntity().setFirstOperand(NUMBER_TEN)
        model.getEntity().setOperator(DIV)
        model.getEntity().setSecondOperand(NUMBER_THREE)
        presenter.onEqualButtonPressed()
        assertEquals(DIV_RESULT, model.getEntity().getFirstOperand())
        verify(view).setResult(DIV_RESULT)
    }

    @Test
    fun `checked correct multiplication operation and showing the result value in view`() {
        model.getEntity().setFirstOperand(NUMBER_TEN)
        model.getEntity().setOperator(TIMES)
        model.getEntity().setSecondOperand(NUMBER_THREE)
        presenter.onEqualButtonPressed()
        assertEquals(TIMES_RESULT, model.getEntity().getFirstOperand())
        verify(view).setResult(TIMES_RESULT)
    }

    @Test
    fun `checked correct add operation with negative number and showing the result value in view`() {
        model.getEntity().setFirstOperand(NEGATIVE_FOUR)
        model.getEntity().setOperator(PLUS)
        model.getEntity().setSecondOperand(NUMBER_THREE)
        presenter.onEqualButtonPressed()
        assertEquals(NEGATIVE_ADD_RESULT, model.getEntity().getFirstOperand())
        verify(view).setResult(NEGATIVE_ADD_RESULT)
    }

    @Test
    fun `checked correct on delete pressed button and showing the result value in view`() {
        model.getEntity().setFirstOperand(NUMBER_TEN)
        model.getEntity().setOperator(MINUS)
        model.getEntity().setSecondOperand(NUMBER_FIFTY_TWO)
        presenter.onDeletePressed()
        assertEquals(NUMBER_FIVE, model.getEntity().getSecondOperand())
        verify(view).setResult(DELETE_RESULT)
    }

    @Test
    fun `checked correct on clear pressed button and showing the result value in view`() {
        model.getEntity().setFirstOperand(NUMBER_TEN)
        model.getEntity().setOperator(MINUS)
        model.getEntity().setSecondOperand(NUMBER_FIFTY_TWO)
        presenter.onClearPressed()
        verify(view).setResult(ZERO)
    }
}

