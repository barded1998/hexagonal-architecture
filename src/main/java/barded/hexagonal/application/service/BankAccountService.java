package barded.hexagonal.application.service;

import barded.hexagonal.application.in.DepositUseCase;
import barded.hexagonal.application.in.WithdrawUseCase;
import barded.hexagonal.application.out.LoadAccountPort;
import barded.hexagonal.application.out.SaveAccountPort;
import barded.hexagonal.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    @Override
    public void deposit(Long id, int amount) {
        BankAccount account = loadAccountPort.load(id);

        account.deposit(amount);

        saveAccountPort.save(account);
    }

    @Override
    public boolean withdraw(Long id, int amount) {
        BankAccount account = loadAccountPort.load(id);
        boolean hasWithdrawn = account.withdraw(amount);
        if (hasWithdrawn) {
            saveAccountPort.save(account);
        }
        return hasWithdrawn;
    }
}
