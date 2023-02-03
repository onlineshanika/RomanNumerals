package com.techreturners.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    @Test
    public void convertToRomanNumeralsTest() throws OutOfRangeException {

        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("MMCMXLVIII", romanNumerals.convertToRomanNumerals(2948));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    public void testWithCsvFileSourceFromClasspath(int arabic, String roman) throws OutOfRangeException {

        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals(roman, romanNumerals.convertToRomanNumerals(arabic));

    }


    @Test
    public void numberOutOfGivenRangeTest() {
        assertThrows(OutOfRangeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new RomanNumerals().convertToRomanNumerals(6855);
            }
        });
    }
}
