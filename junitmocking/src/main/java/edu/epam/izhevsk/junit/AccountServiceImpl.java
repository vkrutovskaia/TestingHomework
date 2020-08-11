package edu.epam.izhevsk.junit;

public class AccountServiceImpl implements AccountService {
    @Override
    public boolean isUserAuthenticated(Long userId) {
        return true;
    }
}
