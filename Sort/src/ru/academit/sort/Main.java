package ru.academit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> convertToInteger(ArrayList<String> list) {
        ArrayList<Integer> listInteger = new ArrayList<>();
        for (String e : list) {
            try {
                listInteger.add(Integer.parseInt(e));
            } catch (NumberFormatException exception) {
                System.out.println("Файл содержит недопустимые символы " + e);
            }
        }
        return listInteger;
    }

    public static void main(String[] args) {

        String help = "Введите 4 аргумента:" + System.lineSeparator() + "Первый аргумент: имя файла с входными данными" + System.lineSeparator()
                + "Второй аргумент: имя файла для записи результаты программы" + System.lineSeparator()
                + "Третий аргумент: i - входной файл содержит числа типа Integer, s - файл содержит строки String" + System.lineSeparator()
                + "Четвертый аргумент: a - отсортировать по возрастанию, d - отсортировать по убыванию";

        if (args[0].equals("help")) {
            System.out.println(help);
            return;
        }

        if (args.length != 4) {
            System.out.println("Неверное количество аргументов");
            System.out.println("Введите help для справки");
            return;
        }

        try (Scanner scanner = new Scanner(new FileInputStream(args[0])); PrintWriter writer = new PrintWriter(args[1])) {
            ArrayList<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            switch (args[2]) {
                case "s":
                    switch (args[3]) {
                        case "a":
                            SortInsertion.sortInsertionAscending(list, new ComparatorString());
                            for (String e : list) {
                                writer.println(e);
                            }
                            System.out.println(list);
                            break;
                        case "d":
                            SortInsertion.sortInsertionAscending(list, new ComparatorString());
                            Collections.reverse(list);
                            for (String e : list) {
                                writer.println(e);
                            }
                            System.out.println(list);
                            break;
                        default:
                            System.out.println("Неверно задан 4 аргумент");
                            System.out.println("Введите help для справки");
                            break;
                    }
                    break;
                case "i":
                    ArrayList<Integer> listInt = convertToInteger(list);
                    switch (args[3]) {
                        case "a":
                            SortInsertion.sortInsertionAscending(listInt, new ComparatorInteger());
                            for (int e : listInt) {
                                writer.println(e);
                            }
                            System.out.println(listInt);
                            break;
                        case "d":
                            SortInsertion.sortInsertionAscending(listInt, new ComparatorInteger());
                            Collections.reverse(listInt);
                            for (int e : listInt) {
                                writer.println(e);
                            }
                            System.out.println(listInt);
                            break;
                        default:
                            System.out.println("Неверно задан 4 аргумент");
                            System.out.println("Введите help для справки");
                            break;
                    }
                    break;
                default:
                    System.out.println("Неверно задан 3 аргумент");
                    System.out.println("Введите help для справки");
                    break;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }
}
