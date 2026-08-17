package ru.aston.hometask.task2;

import java.io.BufferedReader ;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Path path = Path.of("students.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Student student = parseLine(line);
                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        /*
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted((b1, b2) -> b1.getPagesNumber().compareTo(b2.getPagesNumber()))
                .distinct()
                .peek(b -> System.out.println("Distinct: " + b))
                .filter(b -> b.getReleaseYear().isAfter(Year.of(2000)))
                .limit(3)
                .peek(b -> System.out.println("Limit: " + b))
                .map(Book::getReleaseYear)
                .forEach(System.out::println);
        */

        /*
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted((b1, b2) -> b1.getPagesNumber().compareTo(b2.getPagesNumber()))
                .distinct()
                .peek(b -> System.out.println("Distinct: " + b))
                .filter(b -> b.getReleaseYear().isAfter(Year.of(2000)))
                .limit(3)
                .peek(b -> System.out.println("Limit: " + b))
                .map(Book::getReleaseYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
        */

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted((b1, b2) -> b1.getPagesNumber().compareTo(b2.getPagesNumber()))
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

    private static Student parseLine(String line) {
        String[] data = line.split(";");

        Student student = Student.fromString(data[0]);

        for (int i = 1; i < data.length; i++) {
            Book book = Book.fromString(data[i]);
            student.addBook(book);
        }

        return student;
    }
}
