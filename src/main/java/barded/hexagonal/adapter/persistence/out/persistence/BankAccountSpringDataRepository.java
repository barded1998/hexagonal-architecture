package barded.hexagonal.adapter.persistence.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountSpringDataRepository extends JpaRepository<BankAccountJpaEntity, Long> {
}
