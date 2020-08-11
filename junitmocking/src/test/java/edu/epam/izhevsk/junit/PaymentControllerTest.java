package edu.epam.izhevsk.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.*;

public class PaymentControllerTest {

    @Mock
    private AccountService accountService = new AccountServiceImpl();

    @Mock
    private DepositService depositService = new DepositServiceImpl();

    @InjectMocks
    PaymentController paymentController = new PaymentController(accountService, depositService);


    private static final long USER_ID = 100L;
    private static final long AMOUNT = 50L;

    @Before
    public void setUp() throws InsufficientFundsException {
        MockitoAnnotations.openMocks(this);
        accountService = mock(AccountServiceImpl.class);
        depositService = mock(DepositServiceImpl.class);
        paymentController = mock(PaymentController.class);
        depositService.deposit(AMOUNT, USER_ID);
        accountService.isUserAuthenticated(USER_ID);
        paymentController.deposit(AMOUNT, USER_ID);
        paymentController.deposit(60L, 120L);
        accountService.isUserAuthenticated(120L);
    }

    @Test
    public void isUserAuthenticated() {
        when(accountService.isUserAuthenticated(100L)).thenReturn(true).thenReturn(false);
        verify(accountService).isUserAuthenticated(100L);
    }

    @Test
    public void deposit() throws InsufficientFundsException {
        when(depositService.deposit(eq(AMOUNT), anyLong())).thenReturn("Deposit is successful");
    }

    @Test
    public void depositIsSuccessful() throws InsufficientFundsException {
        doThrow(new InsufficientFundsException()).when(paymentController).deposit(geq(AMOUNT), anyLong());
        verify(accountService).isUserAuthenticated(100L);
    }

    @Test
    public void failedDepositForUnauthenticatedUserTest() {
        when(accountService.isUserAuthenticated(not(eq(USER_ID)))).thenReturn(false);
    }

    @Test
    public void failedDepositOfLargeAmountTest() throws SecurityException, InsufficientFundsException {
        doThrow(SecurityException.class).when(paymentController).deposit(geq(AMOUNT), geq(USER_ID));
        System.out.println("User not authenticated: " + USER_ID);
    }
}
