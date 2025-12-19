package org.example;

// Задание 1. Создать классы Собака и Кот с наследованием от класса Животное.

// Класс Животное
abstract class Animals {
    public String name;
    public static int animalCount = 0;

    public Animals(String name) {
        this.name = name;
        animalCount++;
    }

    public static int countAnimals() {
        return animalCount;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}

// Класс Собака

class Dog extends Animals {
    private static int dogCount = 0;
    int maxRun = 500;
    int maxSwim = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (0 < distance && distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }
    @Override
    public void swim(int distance) {
        if (0 < distance && distance <= maxSwim) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + "м.");
        }
    }

    public static int countDogs() {
        return dogCount;
    }
}

// Класс Кот

class Cat extends Animals {
    private static int catCount = 0;
    int maxRun = 200;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (0 < distance && distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int countCats() {
        return catCount;
    }
}


//Задание 2. Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.

interface Shapes {
    double getP();
    double getS();
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + getP());
        System.out.println("Площадь: " + getS());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}

// Класс Круг

class Circle implements Shapes {
    private final double radius;
    private final String fillColor;
    private final String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getP() {
        return 2 * Math.PI * radius;
    }

    public double getS() {
        return Math.PI * radius * radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}


// Класс Прямоугольник

class Rectangle implements Shapes {
    private final double height;
    private final double width;
    private final String fillColor;
    private final String borderColor;

    public Rectangle(double height, double width, String fillColor, String borderColor) {
        this.height = height;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getP() {
        return (height + width) * 2;
    }

    public double getS() {
        return height * width;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}

// Класс Треугольник

class Triangle implements Shapes {
    private final double side1;
    private final double side2;
    private final double side3;
    private final String fillColor;
    private final String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getP() {
        return side1 + side2 + side3;
    }

    public double getS() {
        double p = getP() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}


public class Lesson_4 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        dog1.run(400);
        dog1.swim(5);

        Cat cat1 = new Cat("Матроскин");
        Cat cat2 = new Cat("Барсик");

        System.out.println("Создано животных: " + Animals.countAnimals());
        System.out.println("Создано собак: " + Dog.countDogs());
        System.out.println("Создано котов: " + Cat.countCats());


        Shapes circle = new Circle(5, "Красный", "Черный");
        Shapes rectangle = new Rectangle(4, 6, "Синий", "Белый");
        Shapes triangle = new Triangle(3, 4, 5, "Зеленый", "Желтый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}




















