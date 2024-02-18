package com.parkh.cleancode.ch11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankProxyHandler implements InvocationHandler {
    private Bank bank;

    public BankProxyHandler(Bank bank) {
        this.bank = bank;
    }


    public Object invoke(Object proxy, Method method, Object[] args) {
        String methodName = method.getName();
        if (methodName.equals("getAccounts")) {
            bank.setAccounts(getAccountsFromDatabase());
            return bank.getAccounts();
        } else if (methodName.equals("setAccounts")) {
            bank.setAccounts((Collection<Account>) args[0]);
            setAccountsToDatabase(bank.getAccounts());
            return null;
        }
        // ....
        return null;
    }

    // 세부 사항
    private Collection<Account> getAccountsFromDatabase() {
        System.out.println("DB 연결.... 데이터 조회");
        return accountsInDb;
    }

    private void setAccountsToDatabase(Collection<Account> accounts) {
        System.out.println("DB 연결.... 데이터 저장");
        accountsInDb.clear();
        accountsInDb.addAll(accounts);
    }

    private Collection<Account> accountsInDb = new ArrayList<>(List.of(new Account(1L), new Account(2L)));
}
