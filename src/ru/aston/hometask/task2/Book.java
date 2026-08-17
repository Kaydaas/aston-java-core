package ru.aston.hometask.task2;

import java.time.Year;
import java.util.Objects;

public class Book {
    private final String title;
    private final Integer pages_number;
    private final Year release_year;

    public Book(String title, int pages_number, Year release_year) {
        this.title = title;
        this.pages_number = pages_number;
        this.release_year = release_year;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getPagesNumber() {
        return this.pages_number;
    }

    public Year getReleaseYear() {
        return this.release_year;
    }

    public static Book fromString(String string) {
        String[] parts = string.split(",");

        String title = parts[0];
        int pages_number = Integer.parseInt(parts[1]);
        Year release_year = Year.of(Integer.parseInt(parts[2]));

        return new Book(title, pages_number, release_year);
    }

    public String toString() {
        return String.format(
                "Книга { Название=%s, кол-во страниц=%s, дата выхода=%s }",
                this.getTitle(),
                this.getPagesNumber(),
                this.getReleaseYear()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return Objects.equals(title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}