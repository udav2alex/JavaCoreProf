package homework6;

import java.util.Arrays;

public class ArrayTailMaker {

    public static int[] getTailFor4(int[] arr) throws RuntimeException {
        // TODO 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
        // Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
        // идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
        // + иначе в методе необходимо выбросить RuntimeException.
        // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
        // Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

        // первая 4, последняя 4, в середине 4, несколько 4 подряд

        final int SEARCH_NUMBER = 4;
        int foundPosition = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == SEARCH_NUMBER) {
                foundPosition = i;
                break;
            }
        }

        if (foundPosition == -1) throw new RuntimeException("Массив не содержит число 4!");
        return Arrays.copyOfRange(arr, foundPosition + 1, arr.length);
    }
}
