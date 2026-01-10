package org.example;
import java.util.Scanner;

public class ArifmOper {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите два числа:");
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        try {
            System.out.printf("Сумма чисел равна %d\n", sum(num1, num2));
            System.out.printf("Разность чисел равна %d\n", sub(num1, num2));
            System.out.printf("Произведение чисел равно %d\n", mul(num1, num2));
            System.out.printf("Частное чисел равно %.2f\n", div(num1, num2));
        }
        catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }

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