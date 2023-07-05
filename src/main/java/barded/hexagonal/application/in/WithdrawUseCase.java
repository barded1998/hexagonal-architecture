package barded.hexagonal.application.in;

public interface WithdrawUseCase {
    boolean withdraw(Long id, int amount);
}
