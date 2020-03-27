package homework7;

public class Main {
    public static void main(String[] args) {
        System.out.println("Запускаем тест по объекту Class:");
        try {
            TestStarter.start(TestClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Запускаем тест по имени класса:");
        try {
            TestStarter.start("homework7.TestClass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
