package homework1.fruits_and_boxes;

public class Main {
    // TODO 3. Есть классы Fruit -> Apple, Orange. Класс Box, в который можно складывать фрукты.
    // В одну коробку нельзя сложить и яблоки, и апельсины. Для хранения фруктов можно использовать ArrayList.

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        System.out.println("Наполняем appleBox - кладем 15 яблок...");
        for (int i = 0; i < 15; i++) {
            appleBox.put(new Apple());
        }

        System.out.println("Наполняем orangeBox1 - кладем 10 апельсинов...");
        for (int i = 0; i < 10; i++) {
            orangeBox1.put(new Orange());
        }

        System.out.println("Наполняем orangeBox2 - кладем 5 апельсинов...");
        for (int i = 0; i < 5; i++) {
            orangeBox2.put(new Orange());
        }

        System.out.println("Вес коробки appleBox - " + appleBox.getWeight());
        System.out.println("Вес коробки orangeBox1 - " + orangeBox1.getWeight());
        System.out.println("Вес коробки orangeBox2 - " + orangeBox2.getWeight());

        System.out.println("orangeBox1 того же веса, что и appleBox? " + orangeBox1.compare(appleBox));
        System.out.println("orangeBox1 того же веса, что и orangeBox2? " + orangeBox1.compare(orangeBox2));

        System.out.println("Пересыпаем фрукты из orangeBox1 в orangeBox2...");
        orangeBox1.move(orangeBox2);
        System.out.println("Вес коробки orangeBox1 - " + orangeBox1.getWeight());
        System.out.println("Вес коробки orangeBox2 - " + orangeBox2.getWeight());
    }
}
