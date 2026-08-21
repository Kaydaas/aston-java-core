package ru.aston.hometask.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
    public static List<Student> parseFile(String filePath) {
        List<Student> students = new ArrayList<>();
        Path path = Path.of(filePath);

        try (var lines = Files.lines(path)) {
            lines.map(StudentReader::parseLine)
                    .forEach(students::add);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return students;
    }

    private static Student parseLine(String line) {
        String[] data = line.split(";");

        String[] studentParts = data[0].split(" ");

        String firstName = studentParts[0];
        String lastName = studentParts[1];

        List<Book> books = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            Book book = Book.fromString(data[i]);
            books.add(book);
        }

        return new Student(firstName, lastName, books);
    }
}