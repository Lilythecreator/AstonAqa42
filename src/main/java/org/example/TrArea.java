package org.example;
import java.util.Scanner;

public class TrArea {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите высоту и основание треугольника (в см):");
        int height = in.nextInt();
        int base = in.nextInt();
        try {
            double sq = getArea(height, base);
            System.out.printf("Площадь треугольника с основанием %d см, и высотой %d см равна %.2f см.", height, base, sq);
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    public static double getArea(int height, int base) {
        if (height <= 0 || base <= 0 ) {
            throw new IllegalArgumentException("Длины сторон должны быть больше 0");
        }
        return 0.5 * height * base;
    }
}