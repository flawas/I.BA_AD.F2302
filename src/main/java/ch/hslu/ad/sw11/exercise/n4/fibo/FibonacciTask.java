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
package ch.hslu.ad.sw11.exercise.n4.fibo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Codevorlage für ein klassisches Beispiel zur Berechnung von Fibonacci Zahlen.
 */
@SuppressWarnings("serial")
public final class FibonacciTask extends RecursiveTask<Long> {

    private static final Logger Log = LogManager.getLogger();
    private final int n;

    /**
     * Erzeugt einen Fibonacci Task.
     *
     * @param n für die Fibonacci Berechnung.
     */
    public FibonacciTask(final int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        return fibonacci(this.n);
    }

    private Long fibonacci(final int n){
        if (n < 2){
            return (long) n;
        } else if(n < 30){
            return fibonacci(n-2) + fibonacci(n-1);
        } else {
            ForkJoinTask task1 = new FibonacciTask(n-1).fork();
            ForkJoinTask task2 = new FibonacciTask(n-2).fork();
            try {
                return (long) task1.get() + (long) task2.get();
            } catch (InterruptedException | ExecutionException ex){
                Log.error("Calculation failed: " + ex);
                return (long) 0;
            }
        }
    }
}
