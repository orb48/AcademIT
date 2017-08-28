package ru.academit.sort;


import java.util.ArrayList;
import java.util.Comparator;

public class SortInsertion {

    private SortInsertion() {

    }

    public static <T> void sortInsertionAscending(ArrayList<T> array, Comparator<T> tComparator) {

        for (int i = 1; i < array.size(); ++i) {
            T temp = array.get(i);
            int j = i - 1;
            while (j >= 0 && tComparator.compare(temp, array.get(j)) < 0) {
                array.set(j + 1, array.get(j));
                --j;
            }
            array.set(j + 1, temp);
        }
    }
}
