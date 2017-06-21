import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListTask {
    public static void main(String[] args) throws FileNotFoundException {
        //задача 1
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {

            ArrayList<String> list = new java.util.ArrayList<>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            System.out.println(list);
        }

        // задача 2
        ArrayList<Integer> listInt = new java.util.ArrayList<>(Arrays.asList(1, 2, 5, 7, 8));

        for (int i = 0; i < listInt.size(); ++i) {
            if (listInt.get(i) % 2 == 0) {
                listInt.remove(i);
            }
        }
        System.out.println(listInt);

        //задача 3
        ArrayList<Integer> listIntNew = new java.util.ArrayList<>(Arrays.asList(1, 1, 2, 5, 7, 8, 2, 8));
        ArrayList<Integer> listWithoutRepetitions = new java.util.ArrayList<>();
        for (Integer e : listIntNew) {
            if (listWithoutRepetitions.indexOf(e) == -1) {
                listWithoutRepetitions.add(e);
            }
        }
        System.out.println(listWithoutRepetitions);
    }
}
