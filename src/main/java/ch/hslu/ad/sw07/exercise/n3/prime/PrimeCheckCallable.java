/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw07.exercise.n3.prime;


import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeCheckCallable implements Callable<Boolean> {

    BigInteger bi = new BigInteger(1024, new Random());
    @Override
    public Boolean call() throws Exception {
        try {
            return bi.isProbablePrime(Integer.MAX_VALUE);
        } catch (Exception e){
            throw new Exception();
        }
    }

    public BigInteger getBi() {
        return bi;
    }
}
