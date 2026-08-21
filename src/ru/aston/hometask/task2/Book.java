package ru.aston.hometask.task2;

import java.time.Year;
import java.util.Objects;

public class Book {
    private final String title;
    private final Integer pagesNumber;
    private final Year releaseYear;

    public Book(String title, int pagesNumber, Year releaseYear) {
        this.title = title;
        this.pagesNumber = pagesNumber;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getPagesNumber() {
        return this.pagesNumber;
    }

    public Year getReleaseYear() {
        return this.releaseYear;
    }

    public static Book fromString(String string) {
        String[] parts = string.split(",");

        String title = parts[0];
        int pagesNumber = Integer.parseInt(parts[1]);
        Year releaseYear = Year.of(Integer.parseInt(parts[2]));

        return new Book(title, pagesNumber, releaseYear);
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