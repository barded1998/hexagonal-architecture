package barded.hexagonal.domain;

import lombok.Builder;

import java.math.BigDecimal;

public class BankAccount {

    private Long id;
    private int balance;

    @Builder
    public BankAccount(Long id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (balance < 0) {
            return false;
        }

        this.balance -= balance;
        return true;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public Long getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }
}
