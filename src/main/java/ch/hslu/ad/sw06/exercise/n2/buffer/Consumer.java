/*
 * Copyright 2023 Hochschule Luzern - Informatik.
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
package ch.hslu.ad.sw06.exercise.n2.buffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Konsument, der soviele Werte aus einer Queue liest, wie er nur kann.
 */
public final class Consumer implements Runnable {

    private static final Logger LOG = LogManager.getLogger(Consumer.class);
    private final BoundedBuffer<Integer> queue;
    private long sum;

    /**
     * Erzeugt einen Konsumenten, der soviel Integer-Werte ausliest, wie er nur kann.
     * @param queue Queue zum Lesen der Integer-Werte.
     */
    public Consumer(final BoundedBuffer<Integer> queue) {
        this.queue = queue;
        this.sum = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer temp = queue.remove(10);
                if (temp == null) {
                    LOG.info("Consumer get timeout");
                    break;
                }
                sum += temp;
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    /**
     * Liefert die Summe aller ausgelesener Werte.
     * @return Summe.
     */
    public long getSum() {
        return sum;
    }
}
