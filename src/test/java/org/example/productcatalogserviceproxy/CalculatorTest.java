package org.example.productcatalogserviceproxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void test_AddTwoIntegers_ReturnsInteger() {
        //Arrange
        Calculator c = new Calculator();

        //Act
        int result = c.add(1,2);

        //Assert
        assert(3==result);
    }

    @Test
    public void test_DivideByZero_ThrowsException() {
        //Arrange
        Calculator c = new Calculator();

        //Assert
        assertThrows(ArithmeticException.class, () -> c.divide(1,0));
    }

}