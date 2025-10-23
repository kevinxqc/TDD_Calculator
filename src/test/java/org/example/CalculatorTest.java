package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Calculator Unit Tests")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("should correctly add two positive numbers")
    void testAddition() {
        int result = calculator.add(2, 3);
        assertThat(result)
                .isEqualTo(5)
                .isPositive();
    }

    @Test
    @DisplayName("should handle subtraction correctly")
    void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertThat(result)
                .isEqualTo(6)
                .isGreaterThan(0);
    }

    @Test
    @DisplayName("should multiply numbers correctly")
    void testMultiplication() {
        int result = calculator.multiply(3, 4);
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("should divide numbers correctly")
    void testDivision() {
        double result = calculator.divide(10, 2);
        assertThat(result).isEqualTo(5.0);
    }

    @DisplayName("should throw when dividing by zero")
    @Test
    void testDivisionByZero() {
        assertThatThrownBy(() -> calculator.divide(5, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("zero");
    }

    @Test
    @DisplayName("should handle negative numbers in addition")
    void testAdditionWithNegativeNumbers() {
        int result = calculator.add(-5, 3);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("should handle multiplication with zero and negative numbers")
    void testMultiplicationWithZeroAndNegative() {
        assertThat(calculator.multiply(0, 5)).isZero();
        assertThat(calculator.multiply(-3, 4)).isEqualTo(-12);
    }


}
