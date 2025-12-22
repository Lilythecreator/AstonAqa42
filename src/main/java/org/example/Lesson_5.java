package org.example;

// 1) Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// 2) Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super("Неверные данные в ячейке [" + row + "][" + col + "]");
    }
}

public class Lesson_5 {

    public static int sumArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        for (String[] strings : array) {
            if (strings.length != 4 | array.length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4x4");
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }


    // 3) В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма элементов массива: " + sumArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // 4) Напишите код для генерации и поимки ArrayIndexOutOfBoundsException

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: индекс находится за пределами массива");
        }
    }
}

