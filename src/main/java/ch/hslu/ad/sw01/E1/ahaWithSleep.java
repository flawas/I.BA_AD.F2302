package ch.hslu.ad.sw01.E1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ahaWithSleep {

    private static final Logger Log = LogManager.getLogger();

    private static ahaCounter counter = new ahaCounter();

    public static void main(String[] args) throws InterruptedException {
        task(50);
    }

    public static void task(final int n) throws InterruptedException {
        long starttime = System.nanoTime();
        task1(); task1(); task1(); task1();
        for (int i = 0; i < n; i++) {
            task2(); task2(); task2();
            for (int j = 0; j < n; j++) {
                task3(); task3();
            }
        }
        Log.info("Der Task wurde " + counter.getCount() + "x ausgeführt.");
        long endtime = System.nanoTime();
        double elapsedTimeInSecond = (double) (endtime - starttime) / 1_000_000_000;
        Log.info("Beanspruchte Zeit: " + elapsedTimeInSecond);

    }

    public static void task1() throws InterruptedException {
        counter.setCountPlusOne();
        Thread.sleep(5);
        Log.info("Task 1 ausgeführt.");
    }

    public static void task2() throws InterruptedException {
        counter.setCountPlusOne();
        Thread.sleep(5);
        Log.info("Task 2 ausgeführt.");
    }

    public static void task3() throws InterruptedException {
        counter.setCountPlusOne();
        Thread.sleep(5);
        Log.info("Task 3 ausgeführt.");
    }
}
