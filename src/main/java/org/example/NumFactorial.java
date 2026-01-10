package org.example;

public class NumFactorial {

    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Факториал вычисляется только для неотрицательных чисел");
        } else if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
