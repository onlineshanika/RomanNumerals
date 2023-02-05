package com.techreturners.numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToArabic {

    public final static String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";


    public int convertToArabicNumerals(String roman) {
        if (roman != null && roman.length() > 0) {
            if (validationOfRomanNumerals(roman)) {
                int number = 0;
                for (int i = 0; i < roman.length(); i++) {
                    char c = roman.charAt(i);
                    switch (c) {
                        case 'I':
                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X'))
                                    ? number - 1
                                    : number + 1;
                            break;
                        case 'V':
                            number += 5;
                            break;
                        case 'X':
                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C'))
                                    ? number - 10
                                    : number + 10;
                            break;
                        case 'L':
                            number += 50;
                            break;
                        case 'C':
                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'D' || roman.charAt(i + 1) == 'M'))
                                    ? number - 100
                                    : number + 100;
                            break;
                        case 'D':
                            number += 500;
                            break;
                        case 'M':
                            number += 1000;
                            break;
                    }
                }

                return number;
            } else {
                // invalidate input format exception
            }
        } else {
            // invalidate input exception
        }
        return 0;
    }


    public static boolean validationOfRomanNumerals(String inputString) {
        Pattern p = Pattern.compile(regex);
        if (inputString == null) {
            return false;
        }
        Matcher m = p.matcher(inputString);
        return m.matches();
    }


}
/*
validation
1.check null
2.check length
3.check regex



 */