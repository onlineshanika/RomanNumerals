package com.techreturners.numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToArabic {

    public final static String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";


    public int convertToArabicNumerals(String roman) throws InvalidateInputFormatException, InvalidateInputException {
        if (roman != null && roman.length() > 0) {
            if (validationOfRomanNumerals(roman)) {
                int number = 0;
                for (int i = 0; i < roman.length(); i++) {
                    char c = roman.charAt(i);
                    switch (c) {
                        case 'I' ->
//                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X'))
//                                    ? number - 1
//                                    : number + 1;
                                number = calculateNumber(i, roman, 1, number, 'V', 'X');
                        case 'V' -> number += 5;
                        case 'X' ->
//                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C'))
//                                    ? number - 10
//                                    : number + 10;

                                number = calculateNumber(i, roman, 10, number, 'L', 'C');
                        case 'L' -> number += 50;
                        case 'C' ->
//                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'D' || roman.charAt(i + 1) == 'M'))
//                                    ? number - 100
//                                    : number + 100;
                                number = calculateNumber(i, roman, 100, number, 'D', 'M');
                        case 'D' -> number += 500;
                        case 'M' -> number += 1000;
                    }
                }

                return number;
            } else {
               throw new InvalidateInputFormatException("");
            }
        } else {
            throw new InvalidateInputException("");
        }
    }


    public static boolean validationOfRomanNumerals(String inputString) {
        Pattern p = Pattern.compile(regex);
        if (inputString == null) {
            return false;
        }
        Matcher m = p.matcher(inputString);
        return m.matches();
    }



    private int calculateNumber(int charIndex,String roman,int addition ,int currentValue,char firstCharToCheck,char secondCharToCheck){
        return  (charIndex != roman.length() - 1 && (roman.charAt(charIndex + 1) == firstCharToCheck || roman.charAt(charIndex + 1) == secondCharToCheck))
                ? currentValue - addition
                : currentValue + addition;
    }

}
/*
validation
1.check null
2.check length
3.check regex



 */