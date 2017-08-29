package ru.academit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class FileOperations {

    private FileOperations() {

    }

    static <T> void writeFile(ArrayList<T> list, String outputFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (T e : list) {
                writer.println(e);
            }
        }
    }

    static ArrayList<String> readFile(String inputFile) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }
        return list;
    }
}
