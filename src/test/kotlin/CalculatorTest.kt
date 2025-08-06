import org.example.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    // --- Sum ---
    @Test
    fun testAdditionPositiveNumbers() {
        // Arrange
        val a = 10.0
        val b = 5.0
        // Act
        val result = calculator.add(a, b)
        // Assert
        assertEquals(15.0, result)
    }

    @Test
    fun testAdditionNegativeNumbers() {
        // Sum of two negative numbers
        val result = calculator.add(-3.0, -7.0)
        assertEquals(-10.0, result)
    }

    @Test
    fun testAdditionWithZero() {
        // Sum with zero
        val result = calculator.add(0.0, 5.0)
        assertEquals(5.0, result)
    }

    @Test
    fun testAdditionExtremeValues() {
        val result = calculator.add(Double.MAX_VALUE, 1.0)
        assertEquals(Double.MAX_VALUE, result)
    }

    // --- subtraction ---
    @Test
    fun testSubtractionPositiveNumbers() {
        val result = calculator.subtract(10.0, 5.0)
        assertEquals(5.0, result)
    }

    @Test
    fun testSubtractionNegativeNumbers() {
        // Subtraction of negative numbers
        val result = calculator.subtract(-10.0, -5.0)
        assertEquals(-5.0, result)
    }

    @Test
    fun testSubtractionWithZero() {
        val result = calculator.subtract(0.0, 5.0)
        assertEquals(-5.0, result)
    }

    @Test
    fun testSubtractionExtremeValues() {
        val result = calculator.subtract(Double.MIN_VALUE, Double.MAX_VALUE)
        assertTrue(result < 0)
    }

    // --- multiplication ---
    @Test
    fun testMultiplicationPositiveNumbers() {
        val result = calculator.multiply(3.0, 4.0)
        assertEquals(12.0, result)
    }

    @Test
    fun testMultiplicationNegativeNumbers() {
        val result = calculator.multiply(-3.0, 4.0)
        assertEquals(-12.0, result)
    }

    @Test
    fun testMultiplicationWithZero() {
        val result = calculator.multiply(0.0, 100.0)
        assertEquals(0.0, result)
    }

    @Test
    fun testMultiplicationExtremeValues() {
        val result = calculator.multiply(Double.MAX_VALUE, 2.0)
        assertTrue(result.isInfinite())
    }

    // --- Division ---
    @Test
    fun testDivisionPositiveNumbers() {
        val result = calculator.divide(10.0, 2.0)
        assertEquals(5.0, result)
    }

    @Test
    fun testDivisionNegativeNumbers() {
        val result = calculator.divide(-10.0, 2.0)
        assertEquals(-5.0, result)
    }

    @Test
    fun testDivisionWithZeroNumerator() {
        val result = calculator.divide(0.0, 5.0)
        assertEquals(0.0, result)
    }

    @Test
    fun testDivisionExtremeValues() {
        // large numbers
        val result = calculator.divide(Double.MAX_VALUE, Double.MIN_VALUE)
        assertTrue(result.isInfinite())
    }

    @Test
    fun testDivisionByZeroThrowsException() {
        // zero division must launch exception
        assertThrows(IllegalArgumentException::class.java) {
            calculator.divide(5.0, 0.0)
        }
    }
}