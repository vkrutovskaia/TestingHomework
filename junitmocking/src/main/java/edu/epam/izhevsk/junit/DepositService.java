package edu.epam.izhevsk.junit;


import java.math.BigDecimal;
import org.mockito.*;

public interface DepositService {
    String deposit(Long amount, Long userId) throws InsufficientFundsException;
}
