package ru.aston.hometask3.builder;

public class Main {
    void main() {
        System.out.println(
                User.builder().firstName("Ivan").lastName("Ivanov").email("ivanivanov@mail.ru").build()
        );

        System.out.println(
                User.builder().firstName("Alexey").lastName("Petrov").middleName("Sergeevich").email("ivanivanov@mail.ru").age(30).build()
        );
    }
}
