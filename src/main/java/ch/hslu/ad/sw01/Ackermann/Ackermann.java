package ch.hslu.ad.sw01.Ackermann;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ackermann {

    private static final Logger Log = LogManager.getLogger();
    static AckermannCounter ackermannCounter = new AckermannCounter();
    public static void main(String[] args) {
        Log.info(ackermann(2,2));
        Log.info("Anzahl Methodenaufrufe: " + ackermannCounter.getCount());
    }

    public static long ackermann(final long n, final long m){
        long ack = 0;
        ackermannCounter.setCountPlusOne();
        if(n == 0){
            return m + 1;
        }
        if(n > 0){
            ack = ackermann(n-1, 1);
            Log.info("n > 0: " + ack);
        }
        if(n > 0 && m > 0){
            ack = ackermann(n - 1, ackermann(n, m - 1));
            Log.info("n > 0 && m > 0: " +ack);
        }
        return ack;
    }
}
