package barded.hexagonal.application.out;

import barded.hexagonal.domain.BankAccount;

import java.util.Optional;

public interface LoadAccountPort {
    BankAccount load(Long id);
}
