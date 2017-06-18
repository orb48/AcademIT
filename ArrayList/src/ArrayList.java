import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayList {
    public static void main(String[] args) throws FileNotFoundException {
        //задача 1
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {

            java.util.ArrayList<String> list = new java.util.ArrayList<>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            for (String s : list) {
                System.out.println(s);
            }
        }
        // задача 2
        java.util.ArrayList<Integer> listInt = new java.util.ArrayList<>(Arrays.asList(1, 2, 5, 7, 8));

        for (int i = 0; i < listInt.size(); ++i) {
            if (listInt.get(i) % 2 == 0) {
                listInt.remove(i);
            }
        }
        for (Integer s : listInt) {
            System.out.println(s);
        }

        //задача 3
        java.util.ArrayList<Integer> listIntNew = new java.util.ArrayList<>(Arrays.asList(1, 1, 2, 5, 7, 8, 2, 8));

        for (int i = 0; i < listIntNew.size(); ++i) {
            if (listIntNew.indexOf(listIntNew.get(i)) != listIntNew.lastIndexOf(listIntNew.get(i))) {
                listIntNew.remove(listIntNew.lastIndexOf(listIntNew.get(i)));
            }
        }
        for (Integer s : listIntNew) {
            System.out.println(s);
        }
    }
}
