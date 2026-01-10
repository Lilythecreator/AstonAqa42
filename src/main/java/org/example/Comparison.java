package org.example;
import java.util.Scanner;

public class Comparison {

    public static String compare(int num1, int num2) {
        if (num1 > num2) {
            return String.format("Число %d больше числа %d", num1, num2);
        } else if (num1 < num2) {
            return String.format("Число %d меньше числа %d", num1, num2);
        } else {
            return "Числа равны";
        }
    }
}