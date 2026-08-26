package ru.aston.hometask2;

import java.util.List;

public class Main {
    static final String FILE_PATH = "src/main/resources/students.txt";

    static void main() {
        List<Student> students = StudentReader.parseFile(FILE_PATH);
        StudentService.findBook(students);
    }
}