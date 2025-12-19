package org.example;

// 1) Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
class Product{

    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private int price;
    private boolean reserved;

    //Конструктор класса должен заполнять эти поля при создании объекта.
    public Product (String name, String prodDate, String manufacturer, String country, int price, boolean reserved) {
        this.name = name;
        this.productionDate = prodDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }

    //Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован: " + reserved);
    }

}

public class Lesson_3 {
    public static void main(String[] args) {

        // 2)Создать массив из 5 товаров.
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025","Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 15 Pro", "10.01.2025", "Apple Inc.", "USA", 7999, false);
        productsArray[2] = new Product("Xiaomi Mi 13", "05.03.2025", "Xiaomi Corp.", "China", 3999, true);
        productsArray[3] = new Product("Huawei P60", "15.02.2025", "Huawei Technologies", "China", 4599, false);
        productsArray[4] = new Product("Sony Xperia 1 V", "20.01.2025", "Sony Corp.", "Japan", 6799, true);

        for (Product product : productsArray) {
            product.printInfo();
        }
    }
}

// 3) Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.

class Park{

    class Attraction{
        private String name;
        private String workingTime;
        private int price;

        public Attraction (String name, String workingTime, int price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }
    }

}
