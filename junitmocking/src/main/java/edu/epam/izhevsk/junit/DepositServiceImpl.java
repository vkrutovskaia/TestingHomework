package edu.epam.izhevsk.junit;

public class DepositServiceImpl implements DepositService {

    @Override
    public String deposit(Long amount, Long userId) throws InsufficientFundsException {
        return "Deposit is successful";
    }
}
