package com.techreturners.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToArabicTest {


    @Test
    public void convertToRomanNumeralsTest() throws OutOfRangeException {

        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(0, romanToArabic.convertToArabicNumerals("0"));
//        assertEquals(2948, romanToArabic.convertToArabicNumerals("MMCMXLVIII"));

    }
}
