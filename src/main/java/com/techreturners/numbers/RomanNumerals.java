package com.techreturners.numbers;

public class RomanNumerals {

//    public static final int[] integerValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//    public static final String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//    public String convertToRomanNumerals(int number) {
//        StringBuilder roman = new StringBuilder();
//        for (int x = 0; x < integerValues.length; x++) {
//            while (number >= integerValues[x]) {
//                number = number - integerValues[x];
//                roman.append(romanLetters[x]);
//            }
//        }
//        return roman.toString();
//    }


    public String convertToRomanNumerals(int number)throws OutOfRangeException {
        StringBuilder roman = new StringBuilder();
        if(number > 0 && number <= 3000){
            for (RomanNumeral romanNumeral: RomanNumeral.getRomanNumeralValues()) {
                while (number >= romanNumeral.getValue()) {
                    number = number - romanNumeral.getValue();
                    roman.append(romanNumeral);
                }
            }
        }else {

                throw new OutOfRangeException(CustomErrorMessage.NUMBER_OUT_OF_RANGE);

        }


        return roman.toString();
    }

    /*
     * get the number is in the range 0<n<3000
     * sample 2948
     * if number >= 1000 -->  true --> 2948-1000  --> number =1948 , romanBuff = M
     * if number >= 1000 -->  true --> 1948-1000  --> number =948 , romanBuff = MM
     * if number >= 900 -->   true --> 948-900  --> number =48 , romanBuff = MMCM
     * if number >= 500 -->   false
     * if number >= 400 -->   false
     * if number >= 100 -->   false
     * if number >= 90 -->    false
     * if number >= 50 -->    false
     * if number >= 40 -->    true --> 48-40 --> number =8 , romanBuff = MMCMXL
     * if number >= 10 -->    false
     * if number >= 9 -->     false
     * if number >= 5 -->     true -->8-5 --> number = 3 ,romanBuff = MMCMXLV
     * if number >= 4 -->     false
     * if number >= 1 -->     true -->3-1 --> number = 2 ,romanBuff = MMCMXLVI
     * if number >= 1 -->     true -->2-1 --> number = 1 ,romanBuff = MMCMXLVII
     * if number >= 1 -->     true -->1-1 --> number = 2 ,romanBuff = MMCMXLVIII
     * */
}
