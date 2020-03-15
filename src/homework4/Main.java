package homework4;

public class Main {
    private static final Object monitor = new Object();
    private static volatile int selector = 0;

    public static void main(String[] args) {
        // TODO 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
        // (порядок – ABСABСABС). Используйте wait/notify/notifyAll

        MyThread t1 = new MyThread(Letters.A);
        MyThread t2 = new MyThread(Letters.B);
        MyThread t3 = new MyThread(Letters.C);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        final Letters myLetter;

        MyThread(Letters myLetter) {
            this.myLetter = myLetter;
        }

        @Override
        public void run() {
            int myLetterNumber = myLetter.ordinal();

            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (selector != myLetterNumber) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print(myLetter.name());
                    selector++;
                    if (selector > 2)
                        selector = 0;

                    monitor.notifyAll();
                }
            }
        }
    }

    private enum Letters {
        A, B, C
    }
}
