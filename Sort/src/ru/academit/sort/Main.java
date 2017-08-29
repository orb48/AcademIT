package ru.academit.sort;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    private static ArrayList<Integer> convertToInteger(ArrayList<String> list) {
        ArrayList<Integer> listInteger = new ArrayList<>(100);
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
                + "Третий аргумент: -i - входной файл содержит числа типа Integer, -s - файл содержит строки String" + System.lineSeparator()
                + "Четвертый аргумент: -a - отсортировать по возрастанию, -d - отсортировать по убыванию";

        if (args.length != 4) {
            System.out.println("Неверное количество аргументов");
            System.out.println("-help для справки" + System.lineSeparator() + help);
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String typeDataFile = args[2];
        String typeSort = args[3];

        if (inputFile.equals("-help")) {
            System.out.println(help);
            return;
        }

        try {
            TypeData type;
            switch (typeDataFile) {
                case "-i":
                    type = TypeData.INTEGER;
                    break;
                case "-s":
                    type = TypeData.STRING;
                    break;
                default:
                    System.out.println("Неверно задан 3 аргумент");
                    System.out.println("Введите 3 аргумент: i - входной файл содержит числа типа Integer, s - файл содержит строки String");
                    return;
            }

            boolean ascending;
            switch (typeSort) {
                case "-a":
                    ascending = true;
                    break;
                case "-d":
                    ascending = false;
                    break;
                default:
                    System.out.println("Неверно задан 4 аргумент для сортировки");
                    System.out.println("Введите 4 аргумент: a - отсортировать по возрастанию, d - отсортировать по убыванию");
                    return;
            }

            ArrayList<String> list = FileOperations.readFile(inputFile);
            if (type == TypeData.INTEGER) {
                ArrayList<Integer> listInt = convertToInteger(list);
                Comparator<Integer> comparator = (ascending) ? new ComparatorInteger() : new ComparatorInteger().reversed();
                SortInsertion.sortInsertionAscending(listInt, comparator);
                FileOperations.writeFile(listInt, outputFile);
                System.out.println(listInt);
            } else {
                Comparator<String> comparator = (ascending) ? new ComparatorString() : new ComparatorString().reversed();
                SortInsertion.sortInsertionAscending(list, comparator);
                FileOperations.writeFile(list, outputFile);
                System.out.println(list);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
