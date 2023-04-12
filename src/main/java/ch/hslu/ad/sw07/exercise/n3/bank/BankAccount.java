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
package ch.hslu.ad.sw07.exercise.n3.bank;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Einfaches Bankkonto, das nur den Kontostand beinhaltet.
 */
public final class BankAccount {

    //private int balance;
    private final AtomicInteger balance;

    /**
     * Erzeugt ein Bankkonto mit einem Anfangssaldo.
     *
     * @param balance Anfangssaldo
     */
    public BankAccount(final int balance) {
        //this.balance = balance;
        this.balance = new AtomicInteger(balance);
    }

    /**
     * Erzeugt ein Bankkonto mit Kontostand Null.
     */
    public BankAccount() {
        //this(0);
        this.balance = new AtomicInteger(0);
    }

    /**
     * Gibt den aktuellen Kontostand zurück.
     *
     * @return Kontostand.
     */
    public int getBalance() {
        //return this.balance;
        return this.balance.get();
    }

    /**
     * Addiert zum bestehen Kontostand einen Betrag hinzu.
     *
     * @param amount Einzuzahlender Betrag
     */
    public void deposite(final int amount) {
        //this.balance += amount;
        this.balance.getAndAdd(amount);
    }

    /**
     * Überweist einen Betrag vom aktuellen Bankkonto an ein Ziel-Bankkonto.
     *
     * @param target Bankkonto auf welches der Betrag überwiesen wird.
     * @param amount zu überweisender Betrag.
     */
    public void transfer(final BankAccount target, final int amount) {
        //this.balance -= amount;
        this.balance.getAndAdd(-amount);
        target.deposite(amount);
    }
}
