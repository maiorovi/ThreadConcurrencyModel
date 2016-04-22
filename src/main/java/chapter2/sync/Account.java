package chapter2.sync;

import java.util.DoubleSummaryStatistics;

public class Account {
    private double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Account(Integer balance) {
        this.balance = balance;
    }

    public synchronized void deposit(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount can`t be < 0 in deposit operation");
        }
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp += amount;
        balance = tmp;
    }


    public synchronized void withdraw(Double amount) {
        double tmp = balance;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp -= amount;
        balance = tmp;
    }
}
