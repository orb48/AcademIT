package ru.academit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

    private FileOperations() {

    }

    public static <T> void writerFile(ArrayList<T> list, String outputFile) throws FileNotFoundException {
        try(PrintWriter writer = new PrintWriter(outputFile)) {
            for (T e : list) {
                writer.println(e);
            }
        }
    }

    public static ArrayList<String> readerFile(String inputFile) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try(Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }
        return list;
    }
}
