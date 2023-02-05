package com.techreturners.numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToArabic {

    public final static String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

//
//    public int convertToArabicNumerals(String roman) throws InvalidateInputFormatException, InvalidateInputException {
//        if (roman != null && roman.length() > 0) {
//            if (validationOfRomanNumerals(roman)) {
//                int number = 0;
//                for (int i = 0; i < roman.length(); i++) {
//                    char c = roman.charAt(i);
//                    switch (c) {
//                        case 'I' ->
////                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X'))
////                                    ? number - 1
////                                    : number + 1;
//                                number = calculateNumber(i, roman, 1, number, 'V', 'X');
//                        case 'V' -> number += 5;
//                        case 'X' ->
////                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C'))
////                                    ? number - 10
////                                    : number + 10;
//
//                                number = calculateNumber(i, roman, 10, number, 'L', 'C');
//                        case 'L' -> number += 50;
//                        case 'C' ->
////                            number = (i != roman.length() - 1 && (roman.charAt(i + 1) == 'D' || roman.charAt(i + 1) == 'M'))
////                                    ? number - 100
////                                    : number + 100;
//                                number = calculateNumber(i, roman, 100, number, 'D', 'M');
//                        case 'D' -> number += 500;
//                        case 'M' -> number += 1000;
//                    }
//                }
//
//                return number;
//            } else {
//               throw new InvalidateInputFormatException("");
//            }
//        } else {
//            throw new InvalidateInputException("");
//        }
//    }
//

    public int convertToArabicNumerals(String roman) throws InvalidateInputFormatException, InvalidateInputException {
        if (roman != null && roman.length() > 0) {
            roman = roman.toUpperCase();
            if (validationOfRomanNumerals(roman)) {
                int number = 0;
                for (int i = 0; i < roman.length(); i++) {
                    if (((i + 1) == roman.length()) || (getValueFromEnum(roman, i) >= (getValueFromEnum(roman, i + 1)))) {
                        number += getValueFromEnum(roman, i);
                    } else {
                        number -= getValueFromEnum(roman, i);
                    }
                }
                return number;
            } else {
                throw new InvalidateInputFormatException(CustomErrorMessage.INVALID_INPUT_FORMAT);
            }
        } else {
            throw new InvalidateInputException(CustomErrorMessage.INVALID_INPUT);
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


//
//    private int calculateNumber(int charIndex,String roman,int addition ,int currentValue,char firstCharToCheck,char secondCharToCheck){
//        return  (charIndex != roman.length() - 1 && (roman.charAt(charIndex + 1) == firstCharToCheck || roman.charAt(charIndex + 1) == secondCharToCheck))
//                ? currentValue - addition
//                : currentValue + addition;
//    }


    private int getValueFromEnum(String romanString, int index) {
        return RomanNumeral.valueOf(String.valueOf(romanString.charAt(index))).getValue();

    }
}
/*
first approach

validation
1.check null
2.check length
3.check regex
loop the roman string  i
number =0
      if the char is I,X,C == >
                 I -->  if it's not the last number and next number is if (V || X) THEN number - 1  else number =+ 1
                 X -->  if it's not the last number and next number is if ( L|| C ) THEN number - 10 else number =+ 10
                 X -->  if it's not the last number and next number is if ( D|| M )  THEN number - 100  else number =+ 100
      else
           if the char is V --> number =+ 5
           if the char is L --> number =+ 50
           if the char is D --> number =+ 500
           if the char is M --> number =+ 1000
 */

/*
2nd approach

validation
1.check null
2.check length
3.check regex
loop the roman string  i
number =0
    is last char of the String  ? number = get the related value from the  roman enum and add that to the number  --- >last step

    if current char numeric value > next char numeric value
      then number += current char numeric value
    else
       number -= current char numeric value  --> for cases like 90,40,400,900,4,9



 */