/*
 * Copyright 2023 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw07.exercise.n3.prime;

import java.math.BigInteger;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 100 grosse Primzahlen produzieren.
 */
public final class PrimeCheck {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.exercise.n3.prime.PrimeCheck.class);

    /**
     * Privater Konstruktor.
     */
    public PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        int n = 1;
        while (n <= 100) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info(n + ": " + bi.toString().substring(0, 20) + "...");
                n++;
            }
        }
    }
}
