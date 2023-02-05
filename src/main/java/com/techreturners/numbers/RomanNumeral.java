package com.techreturners.numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumeral {
    M(1000), CM(900), D(500),CD(400),C(100),
    XC(90), L(50), XL(40),X(10),
    IX(9),V(5),IV(4),I(1) ;

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

//    public static List<RomanNumeral> getReverseSortedValues() {
//        return Arrays.stream(values())
//                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
//                .collect(Collectors.toList());
//    }

    public static List<RomanNumeral> getRomanNumeralValues() {
        return Arrays.stream(values()).toList();
    }
}
