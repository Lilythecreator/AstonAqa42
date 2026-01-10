package org.example;
import java.util.Scanner;


public class TrArea {

    public static double getArea(int height, int base) {
        if (height <= 0 || base <= 0 ) {
            throw new IllegalArgumentException("Длины сторон должны быть больше 0");
        }
        return 0.5 * height * base;
    }
}