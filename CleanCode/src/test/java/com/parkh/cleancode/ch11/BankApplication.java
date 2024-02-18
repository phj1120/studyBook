package com.parkh.cleancode.ch11;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;

public class BankApplication {

    /**
     * POJO 방식 그대로 사용 가능하지만, DB와 관련 된 처리들을 처리 하고 있다.
     *
     * 로그
     * DB 연결.... 데이터 조회
     * Account{accountNo='1'}
     * Account{accountNo='2'}
     * DB 연결.... 데이터 저장
     * DB 연결.... 데이터 조회
     * Account{accountNo='3'}
     * Account{accountNo='4'}
     * FINISH
     */
    @Test
    void proxyTest() {
        Bank bank = (Bank) Proxy.newProxyInstance(
                Bank.class.getClassLoader(),
                new Class[]{Bank.class},
                new BankProxyHandler(new BankImpl())
        );
        Collection<Account> accountsBeforeUpdate = bank.getAccounts();
        accountsBeforeUpdate.forEach(System.out::println);

        bank.setAccounts(List.of(new Account(3L), new Account(4L)));

        Collection<Account> accountsAfterUpdate = bank.getAccounts();
        accountsAfterUpdate.forEach(System.out::println);

        System.out.println("FINISH");
    }
}
