package barded.hexagonal.adapter.persistence.in.web;

import barded.hexagonal.application.in.DepositUseCase;
import barded.hexagonal.application.in.WithdrawUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BankAccountController {

    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    @GetMapping("/deposit/{accountId}/{amount}")
    public String deposit(@PathVariable final Long accountId, @PathVariable final Integer amount) {
        log.info("BankAccountController-deposit");
        depositUseCase.deposit(accountId, amount);

        return "deposit";
    }

    @GetMapping("/withdraw/{accountId}/{amount}")
    public String  withdraw(@PathVariable final Long accountId, @PathVariable final Integer amount) {
        log.info("BankAccountController-withdraw");
        boolean withdraw = withdrawUseCase.withdraw(accountId, amount);
        return Boolean.toString(withdraw);
    }
}
