package com.techreturners.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    @Test
    public void convertToRomanNumeralsTest() throws OutOfRangeException {

        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("MMCMXLVIII", romanNumerals.convertToRomanNumerals(2948));

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
