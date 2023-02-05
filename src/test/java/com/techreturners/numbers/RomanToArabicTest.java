package com.techreturners.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanToArabicTest {


    @Test
    public void convertToRomanNumeralsTest() throws OutOfRangeException, InvalidateInputFormatException, InvalidateInputException {

        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(2948, romanToArabic.convertToArabicNumerals("MMCMXLVIII"));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidTestData.csv")
    public void convertToRomanNumeralsInvalidInputTest(String roman) throws OutOfRangeException, InvalidateInputFormatException, InvalidateInputException {
        assertThrows(InvalidateInputFormatException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new RomanToArabic().convertToArabicNumerals(roman);
            }
        });

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    public void testWithCsvFileSourceFromClasspath(int arabic, String roman) throws InvalidateInputFormatException, InvalidateInputException {

        RomanToArabic romanToArabic = new RomanToArabic();
        assertEquals(arabic, romanToArabic.convertToArabicNumerals(roman));

    }
}
