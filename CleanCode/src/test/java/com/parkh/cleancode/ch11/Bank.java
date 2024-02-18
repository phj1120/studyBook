package com.parkh.cleancode.ch11;

import java.util.Collection;
import java.util.List;

public interface Bank {
    Collection<Account> getAccounts();

    void setAccounts(Collection<Account> accounts);
}
