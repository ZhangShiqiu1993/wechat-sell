package com.ebay.utils;

public class MathUtil {
    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2) {
        return Math.abs(d1 - d2) < MONEY_RANGE;
    }
}
