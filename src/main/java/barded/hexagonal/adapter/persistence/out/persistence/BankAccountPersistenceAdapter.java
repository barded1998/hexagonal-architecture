package barded.hexagonal.adapter.persistence.out.persistence;

import barded.hexagonal.application.out.LoadAccountPort;
import barded.hexagonal.application.out.SaveAccountPort;
import barded.hexagonal.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountSpringDataRepository repository;

    @Override
    public BankAccount load(Long id) {
        BankAccountJpaEntity entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return bankAccountMapper.toDomain(entity);
    }

    @Override
    public void save(BankAccount bankAccount) {
        BankAccountJpaEntity entity = bankAccountMapper.toEntity(bankAccount);
        repository.save(entity);
    }
}
