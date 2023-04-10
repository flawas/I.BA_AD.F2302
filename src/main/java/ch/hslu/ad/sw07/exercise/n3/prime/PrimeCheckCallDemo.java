/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw07.exercise.n3.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeCheckCallDemo {

    private static final Logger LOG = LogManager.getLogger();
    private static final int NUM_OF_PRIME = 100;


    public static void main(String[] args) throws Exception {

        AtomicInteger counter = new AtomicInteger(0);
        final ExecutorService executor = Executors.newCachedThreadPool();
        // Zeitmessung beginnen
        final long timeStart = System.currentTimeMillis();
        boolean working = true;

        while(working){
            executor.execute( () -> {
                PrimeCheckCallable primeCheckCallable = new PrimeCheckCallable();
                try {
                    if((counter.get() <= NUM_OF_PRIME) && (primeCheckCallable.call())){
                        LOG.info(primeCheckCallable.getBi().toString().substring(0, 20) + "...");
                        counter.getAndIncrement();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            if(counter.get() == NUM_OF_PRIME){
                working = false;
                LOG.info("Alle Threads beenden...");
                executor.shutdown();
            }
        }

        // Zeitmessung Stop
        final long timeEnd = System.currentTimeMillis();
        LOG.info("Anzahl Zahlen: " + counter.get());
        LOG.info("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Millisek.");
    }
}
