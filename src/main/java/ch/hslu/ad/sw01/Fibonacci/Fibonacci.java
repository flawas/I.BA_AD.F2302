package ch.hslu.ad.sw01.Fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Logger Log = LogManager.getLogger();

    public static void main(String[] args) {

        long start1 = System.nanoTime();
        Log.info("FiboRec1: " + fiboRec1(10));
        long end1 = System.nanoTime();
        double elapsedTimeInSecond1 = (double) (end1 - start1) / 1_000_000_000;
        Log.info("Beanspruchte Zeit: " + elapsedTimeInSecond1);

        long start2 = System.nanoTime();
        Log.info("FiboRec2: " + fiboRec1(10));
        long end2 = System.nanoTime();
        double elapsedTimeInSecond2 = (double) (end2 - start2) / 1_000_000_000;
        Log.info("Beanspruchte Zeit: " + elapsedTimeInSecond2);

        long start3 = System.nanoTime();
        Log.info(("FiboIter: " + fiboIter(10)));
        long end3 = System.nanoTime();
        double elapsedTimeInSecond3 = (double) (end3 - start3) / 1_000_000_000;
        Log.info("Beanspruchte Zeit: " + elapsedTimeInSecond3);
    }

    public static int fiboRec1(final int n){
        // Rekursionsbasis
        if(n <= 1){
            return n;
        }
        // Rekursionsvorschrift
        return (fiboRec1(n - 1) + fiboRec1(n - 2));
    }

    public static Map<Integer, Integer> database = new HashMap<Integer, Integer>();
    public static int fiboRec2(final int n){
        if(n <= 1){
            return n;
        }
        if(database.containsKey(n)){
            Log.info("Aus Hashmap gelsener Wert: " + n);
            return database.get(n);
        }
        int tmp = fiboRec2(n - 1) + fiboRec2(n - 2);
        database.put(n, tmp);
        return tmp;
    }

    public static int fiboIter(final int n){
        int previous = 0;
        int current = 1;
        int tmp;
        for(int i = 0; i < n; i++){
            // vorherige Zahl in tmp legen
            tmp = previous;
            // current Zahl in previous legen
            previous = current;
            // neue Zahl berechnen
            current += tmp;
        }
        return previous;
    }
}
