package com.envelo.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {

    int[] numbers = new int[]{20, 19, 15, 13, 10, 7, 5, 4, 1, 0};

    @Test
    void searchedValueAtIndex0(){
        int x = numbers[0];
        boolean result = Ex2.search(numbers, x);
        assertTrue(result);
    }

    @Test
    void searchedValueAtLastIndex(){
        int x = numbers[numbers.length-1];
        boolean result = Ex2.search(numbers, x);
        assertTrue(result);
    }

    @Test
    void searchedValueAtMiddleIndex(){
        int x = numbers[(numbers.length-1)/2];
        boolean result = Ex2.search(numbers, x);
        assertTrue(result);
    }

    @Test
    void searchedValueInTheArray(){
        int x = 5;
        boolean result = Ex2.search(numbers, x);
        assertTrue(result);
    }

    @Test
    void searchedValueNotInTheArray(){
        int x = 6;
        boolean result = Ex2.search(numbers, x);
        assertFalse(result);
    }

}