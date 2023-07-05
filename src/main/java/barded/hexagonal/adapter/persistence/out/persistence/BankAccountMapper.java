package barded.hexagonal.adapter.persistence.out.persistence;

import barded.hexagonal.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccount toDomain(BankAccountJpaEntity entity) {
        return BankAccount.builder()
            .id(entity.getId())
            .balance(entity.getBalance())
            .build();
    }

    public BankAccountJpaEntity toEntity(BankAccount domain) {
        return BankAccountJpaEntity.builder()
            .id(domain.getId())
            .balance(domain.getBalance())
            .build();
    }
}
