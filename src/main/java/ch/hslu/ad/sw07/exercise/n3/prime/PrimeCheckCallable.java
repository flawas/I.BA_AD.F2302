/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw07.exercise.n3.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeCheckCallable implements Callable<Boolean> {

    private static final int NUM_OF_PRIMES = 100;
    BigInteger bi = new BigInteger(1024, new Random());
    @Override
    public Boolean call() throws Exception {
        return bi.isProbablePrime(Integer.MAX_VALUE);
    }

    public BigInteger getBi() {
        return bi;
    }
}
