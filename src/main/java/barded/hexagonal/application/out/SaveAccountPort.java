package barded.hexagonal.application.out;

import barded.hexagonal.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}
