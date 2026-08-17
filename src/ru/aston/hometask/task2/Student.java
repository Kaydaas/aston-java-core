package ru.aston.hometask.task2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String first_name;
    private final String last_name;
    private final List<Book> books;

    public Student(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.books = new ArrayList<>();
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public List<Book> getBooks() { return this.books; }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public static Student fromString(String string) {
        String[] parts = string.split(" ");

        String first_name = parts[0];
        String last_name = parts[1];

        return new Student(first_name, last_name);
    }

    public String toString() {
        return String.format(
                "Студент { Имя=%s, фамилия=%s }",
                this.getFirstName(),
                this.getLastName()
        );
    }
}
