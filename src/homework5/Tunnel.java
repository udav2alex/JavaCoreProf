package homework5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore stopLight;

    public Tunnel(int capacity) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        stopLight = new Semaphore(capacity);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                stopLight.acquire();

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                stopLight.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}