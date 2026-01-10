package org.example;
import java.util.Scanner;

public class Comparison {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два числа:");
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        System.out.println(compare(num1, num2));
    }

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