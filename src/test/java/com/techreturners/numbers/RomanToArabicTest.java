package com.techreturners.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToArabicTest {


    @Test
    public void convertToRomanNumeralsTest() throws OutOfRangeException, InvalidateInputFormatException, InvalidateInputException {

        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(2948, romanToArabic.convertToArabicNumerals("MMCMXLVIII"));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    public void testWithCsvFileSourceFromClasspath(int arabic, String roman)throws InvalidateInputFormatException, InvalidateInputException {

        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(arabic, romanToArabic.convertToArabicNumerals(roman));

    }
}
