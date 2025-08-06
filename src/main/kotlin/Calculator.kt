package org.example

// This is a simple calculator class that performs basic arithmetic operations
// such as addition, subtraction, multiplication, and division.
class Calculator {
    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw IllegalArgumentException("ERROR!!! no se puede dividir por cero")
        return a / b
    }
}