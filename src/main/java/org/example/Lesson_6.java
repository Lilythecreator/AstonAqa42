package org.example;
import java.util.*;

// Задание 1
// Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
// Создайте коллекцию, содержащую объекты класса Student.

class Student {

    private final String name;
    private final String group;
    private int course;
    private final List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}


public class Lesson_6 {

    //Следует написать метод, который удаляет студентов со средним баллом < 3

    public static void removeStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    // а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    //Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
    // Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {

        // Задание 1

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иванов Алексей", "513/1", 2, Arrays.asList(5, 4, 4, 3, 4, 5, 3, 3, 4, 5, 5)));
        students.add(new Student("Петров Дмитрий", "42/1", 1, Arrays.asList(2, 2, 3, 4, 4, 4, 4, 2, 3, 3, 5)));
        students.add(new Student("Сидорова Анна", "414/2", 2, Arrays.asList(3, 4, 3, 4, 5, 5, 5, 4, 3, 4, 5)));
        students.add(new Student("Кузнецов Михаил", "414/2", 1, Arrays.asList(2, 2, 2, 3, 3, 2, 2, 3, 2, 2, 2)));
        students.add(new Student("Смирнова Екатерина", "513/1", 1, Arrays.asList(5, 4, 4, 3, 3, 4, 4, 3, 2, 2, 2)));
        students.add(new Student("Попов Сергей", "42/1", 1, Arrays.asList(2, 2, 3, 3, 3, 2, 2, 3, 2, 2, 2)));
        students.add(new Student("Васильева Мария", "414/2", 2, Arrays.asList(3, 4, 3, 3, 3, 4, 4, 3, 2, 2, 2)));
        students.add(new Student("Новиков Артём", "414/2", 1, Arrays.asList(5, 5, 3, 4, 4, 3, 5, 5, 5)));
        students.add(new Student("Морозов Илья", "513/1", 1, Arrays.asList(5, 4, 4, 5, 5, 4, 4, 5, 5, 5, 5)));
        students.add(new Student("Волкова Ольга", "42/1", 2, Arrays.asList(2, 2, 3, 3, 3, 2, 3, 3, 3, 2, 2)));
        students.add(new Student("Фёдоров Андрей", "414/2", 1, Arrays.asList(3, 4, 3, 3, 3, 4, 4, 3, 5, 5, 5)));
        students.add(new Student("Соколова Наталья", "513/1", 2, Arrays.asList(2, 2, 2, 3, 3, 2, 2, 3, 3, 3, 4)));
        students.add(new Student("Лебедев Роман", "513/1", 1, Arrays.asList(5, 4, 4, 5, 5, 4, 4, 5, 2, 5, 3)));
        students.add(new Student("Козлова Татьяна", "42/1", 2, Arrays.asList(2, 3, 3, 3, 3, 2, 2, 5, 2, 2, 4)));
        students.add(new Student("Павлов Никита", "414/2", 1, Arrays.asList(3, 2, 3, 3, 3, 2, 2, 3, 2, 2, 2)));
        students.add(new Student("Орлова Юлия", "42/1", 1, Arrays.asList(4, 4, 4, 5, 5, 4, 4, 5, 3, 3, 3)));

        removeStudents(students);

        promoteStudents(students);

        System.out.println("Студенты 3 курса:");
        printStudents(students, 3);

        //Задание 2

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "89651111111");
        phoneBook.add("Иванов", "89652222222");
        phoneBook.add("Петров", "89653333333");
        phoneBook.add("Петров", "89654444444");
        phoneBook.add("Сидоров", "89655555555");
        phoneBook.add("Кузнецов", "89656666666");
        phoneBook.add("Кузнецов", "89657777777");
        phoneBook.add("Кузнецов", "89658888888");
        phoneBook.add("Смирнов", "89659999999");


        System.out.println("Иванов:");
        for (String phone : phoneBook.get("Иванов")) {
            System.out.println(phone);
        }
    }
}

//Задание 2.
//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.


class PhoneBook {

    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        phoneBook
                .computeIfAbsent(lastName, k -> new ArrayList<>())
                .add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }
}























