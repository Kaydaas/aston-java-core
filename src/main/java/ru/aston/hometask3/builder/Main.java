package ru.aston.hometask3.builder;

public class Main {
    void main() {
        System.out.println(
                new User.Builder().setFirstName("Ivan").setLastName("Ivanov").setEmail("ivanivanov@mail.ru").build()
        );

        System.out.println(
                new User.Builder().setFirstName("Alexey").setLastName("Petrov").setMiddleName("Sergeevich").setEmail("ivanivanov@mail.ru").setAge(30).build()
        );
    }
}
