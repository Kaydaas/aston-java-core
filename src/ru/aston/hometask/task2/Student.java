package ru.aston.hometask.task2;

import java.util.List;

public class Student {
    private final String first_name;
    private final String last_name;
    private final List<Book> books;

    public Student(String first_name, String last_name, List<Book> books) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.books = books;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
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
