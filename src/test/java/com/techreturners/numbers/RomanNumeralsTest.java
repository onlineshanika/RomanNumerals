package com.techreturners.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    @Test
    public void convertToRomanNumeralsTest() {

        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("MMCMXLVII",romanNumerals.convertToRomanNumerals(2948));

    }
}
