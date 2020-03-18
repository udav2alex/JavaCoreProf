package homework6;

public class ArrayCheck {
    // TODO 2. Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    public static boolean checkArray(int[] array) {
        return search(array, 1) != -1 && search(array, 4) != -1;
    }

    private static int search(int[] array, int goal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == goal) return i;
        }
        return -1;
    }
}
