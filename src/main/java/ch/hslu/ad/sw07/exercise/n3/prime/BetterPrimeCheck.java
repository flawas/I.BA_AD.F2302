/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw07.exercise.n3.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BetterPrimeCheck {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Constructor
     */
    public BetterPrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @return
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        LOG.info("Maximal verfügabre Ressourcen: " + Runtime.getRuntime().availableProcessors());

        // Zeitmessung Start
        final long timeStart = System.currentTimeMillis();

        // Neuer Executor Service erzeugen mit einem CachedThreadPool
        final ExecutorService executor = Executors.newCachedThreadPool();
        //final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        // Neue AtomicInteger für die Zählung erzeugen
        AtomicInteger n = new AtomicInteger(1);

        // While Schleife für 100 Berechnungen
        while (n.get() < 100) {
            // Executor ausführen mit der Berechnungsaufgabe, wenn true, dann n inkrementieren
            executor.execute( () -> {
                BigInteger bi = new BigInteger(1024, new Random());
                if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                    LOG.info("Thread" + Thread.currentThread().getId() + ": " + bi.toString().substring(0, 20) + "...");
                    n.getAndIncrement();

                }
            });
        }
        LOG.info("Alle Threads beenden...");
        executor.shutdownNow();

        // Zeitmessung Stop
        final long timeEnd = System.currentTimeMillis();
        if(executor.awaitTermination(500, TimeUnit.MILLISECONDS)){
            LOG.info("Anzahl Zahlen: " + n);
            LOG.info("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Millisek.");
        }
    }
}
