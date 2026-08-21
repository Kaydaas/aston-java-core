package ru.aston.hometask.task2;

import java.time.Year;
import java.util.Comparator;
import java.util.List;

public class StudentService {
    public static void findBook(List<Student> students) {
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparing(Book::getPagesNumber))
                .distinct()
                .filter(b -> b.getReleaseYear().isAfter(Year.of(2000)))
                .limit(3)
                .map(Book::getReleaseYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}