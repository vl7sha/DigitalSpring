package com.example.digitalspring.util;


public class Validator {

    public static boolean isNotNullFIO(String arg) {
        return arg == null;
    }

    public static boolean validMass(Double mass) {
        return mass > 600.0 || mass < 2.0;
    }

    public static boolean validHeight(Double height) {
        return height > 2.9 || height < 0.5;
    }

    public static boolean isNotMinusZero(int age) {
        return age < 0;
    }
}
