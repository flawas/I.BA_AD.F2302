/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw07.exercise.n3.conclist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;

public class DemoBlockingQueue {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.sw07.exercise.n3.conclist.DemoConcurrentList.class);


    /**
     * Main-Demo.
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException bei Excecution-Fehler.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {
        final Queue<Integer> list = new LinkedBlockingQueue<>();
        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            futures.add(executor.submit(new Producer(list, 1000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("prod sum = " + sum);
        }
        LOG.info("prod tot = " + totProd);
        long totCons = executor.submit(new Consumer(list)).get();
        LOG.info("cons tot = " + totCons);
        executor.shutdown();
    }
}
