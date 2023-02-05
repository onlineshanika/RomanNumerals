package com.techreturners.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToArabicTest {


    @Test
    public void convertToRomanNumeralsTest() throws OutOfRangeException, InvalidateInputFormatException, InvalidateInputException {

        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(2948, romanToArabic.convertToArabicNumerals("MMCMXLVIII"));

    }
}
