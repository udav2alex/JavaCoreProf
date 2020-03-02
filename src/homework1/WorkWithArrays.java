package homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WorkWithArrays {

    public static void main(String[] args) {
        System.out.println("Задача 1:");
        String[] strings = {"one", "two", "three", "four", "five"};
        System.out.println(Arrays.toString(strings));
        exchangeElements(strings, 1, 3);
        System.out.println(Arrays.toString(strings));

        System.out.println("");

        System.out.println("Задача 2:");
        System.out.println("array: " + Arrays.toString(strings));
        ArrayList<String> arrayList = convertToArrayList(strings);
        System.out.println("ArrayList: " + arrayList);
    }

    // TODO 1. Написать метод, который меняет два элемента массива местами
    public static <T> void exchangeElements(T[] array, int first, int second) {
        T tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    // TODO 2. Написать метод, который преобразует массив в ArrayList
    public static <T> ArrayList<T> convertToArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>(array.length);
        Collections.addAll(arrayList, array);
        return arrayList;
    }
}
