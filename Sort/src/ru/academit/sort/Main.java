package ru.academit.sort;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    enum TypeData {
        INTEGER, STRING;
    }

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

        if (args.length != 4) {
            System.out.println("Неверное количество аргументов");
            System.out.println("help для справки" + System.lineSeparator() + help);
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String typeDataFile = args[2];
        String typeSort = args[3];

        if (inputFile.equals("help")) {
            System.out.println(help);
            return;
        }

        try {
            ArrayList<String> list = FileOperations.readerFile(inputFile);

            TypeData type;
            switch (typeDataFile) {
                case "i":
                    type = TypeData.INTEGER;
                    break;
                case "s":
                    type = TypeData.STRING;
                    break;
                default:
                    System.out.println("Неверно задан 3 аргумент" + System.lineSeparator() + "Введите 3 аргумент: i - входной файл содержит числа типа Integer, s - файл содержит строки String");
                    return;
            }

            boolean ascending;
            switch (typeSort) {
                case "a":
                    ascending = true;
                    break;
                case "d":
                    ascending = false;
                    break;
                default:
                    System.out.println("Неверно задан 4 аргумент для сортировки" + System.lineSeparator() + "Введите 4 аргумент: a - отсортировать по возрастанию, d - отсортировать по убыванию");
                    return;
            }

            if (type == TypeData.INTEGER) {
                ArrayList<Integer> listInt = convertToInteger(list);
                if (ascending) {
                    SortInsertion.sortInsertionAscending(listInt, new ComparatorInteger());
                } else {
                    SortInsertion.sortInsertionAscending(listInt, new ComparatorInteger().reversed());
                }
                FileOperations.writerFile(listInt, outputFile);
                System.out.println(listInt);
            } else {
                if (ascending) {
                    SortInsertion.sortInsertionAscending(list, new ComparatorString());
                } else {
                    SortInsertion.sortInsertionAscending(list, new ComparatorString().reversed());
                }
                FileOperations.writerFile(list, outputFile);
                System.out.println(list);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
