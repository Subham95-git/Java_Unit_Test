package com.subham.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    @DisplayName("Divisible by three")
    @Test
    @Order(1)
    void testDivisibleByThree(){
        String expected  = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3));
    }

    @DisplayName("Divisible by five")
    @Test
    @Order(2)
    void testDivisibleByFive(){
        String expected  = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5));
    }

    @DisplayName("Not divisible by three or five")
    @Test
    @Order(3)
    void testNotDivisibleByThreeOrFive(){
        String expected  = "2";
        assertEquals(expected, FizzBuzz.compute(2));
    }

    @DisplayName("divisible by three and five")
    @Test
    @Order(4)
    void testDivisibleByThreeAnsFive(){
        String expected  = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15));
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name = " value {0}, expected {1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
