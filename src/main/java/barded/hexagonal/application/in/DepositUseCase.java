package barded.hexagonal.application.in;

public interface DepositUseCase {
    void deposit(Long id, int amount);
}
