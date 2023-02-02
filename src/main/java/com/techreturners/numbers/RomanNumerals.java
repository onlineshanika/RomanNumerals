package com.techreturners.numbers;

public class RomanNumerals {

    public static final String EMPTY = "";

    public String convertToRomanNumerals(int number) {
        if (number > 0 && number <= 3000) {
            StringBuilder roman = new StringBuilder();
            int thousands = number / 1000;
            number = number % 1000;
            if (thousands > 0) {
                roman.append("Thousands-");
            }
            if (number > 0) {
                int hundreds = number / 100;
                number = number % 100;
                if (hundreds > 0) {
                    roman.append("Hundreds-");
                }
                if (number > 0) {
                    int tens = number / 10;
                    number = number % 10;
                    if (tens > 0) {
                        roman.append("Tens-");
                    }
                    if (number > 0) {

                        roman.append("ones");
                    }
                }
            }
            System.out.println(roman);
            return roman.toString();
        }
        return EMPTY;
    }

    /*
     * get the number is in the range 0<n<3000
     * input 2948 ===>MMCMXLVII OUTPUT
     * 2948/1000=> 2==> MM
     * 948/100=>9 ==>CM
     * 48/10=>4 ==>XL
     *  8==>VIII
     *
     * */
}
