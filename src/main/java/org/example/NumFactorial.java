package org.example;
import java.util.Scanner;

public class NumFactorial {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        int num = in.nextInt();
        try {
            System.out.printf("Факториал числа %d равен %d", num, factorial(num));
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

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