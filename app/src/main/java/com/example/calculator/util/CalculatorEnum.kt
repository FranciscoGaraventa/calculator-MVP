package com.example.calculator.util

import com.example.calculator.util.Constants.DIVISION_BY_ZERO_KEY
import com.example.calculator.util.Constants.INCOMPLETE_OPERATION_KEY
import com.example.calculator.util.Constants.INVALID_NUMBER_KEY
import com.example.calculator.util.Constants.NONE_KEY
import com.example.calculator.util.Constants.SUCCESS_KEY

enum class CalculatorEnum(val enum: String) {
    DIVISION_BY_ZERO(DIVISION_BY_ZERO_KEY),
    INCOMPLETE_OPERATION(INCOMPLETE_OPERATION_KEY),
    INVALID_NUMBER(INVALID_NUMBER_KEY),
    NONE(NONE_KEY),
    SUCCESS(SUCCESS_KEY)
}
