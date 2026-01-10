package org.example;
import java.util.Scanner;

public class ArifmOper {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static double div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль. Нельзя вычислить частное");
        }
        return (double) a / b;
    }
}