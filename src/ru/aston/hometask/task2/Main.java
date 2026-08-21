package ru.aston.hometask.task2;

import java.util.List;

public class Main {
    static final String FILE_PATH = "students.txt";

    static void main() {
        List<Student> students = StudentReader.parseFile(FILE_PATH);
        StudentService.findBook(students);
    }
}