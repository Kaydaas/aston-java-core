package ru.aston.hometask.task2;

import java.util.List;

public class Student {
    private final String firstName;
    private final String lastName;
    private final List<Book> books;

    public Student(String firstName, String lastName, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public List<Book> getBooks() { return this.books; }

    public String toString() {
        return String.format(
                "Студент { Имя=%s, фамилия=%s, книги(%s)=%s}",
                this.getFirstName(),
                this.getLastName(),
                books.size(),
                books
        );
    }
}
