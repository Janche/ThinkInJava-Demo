package com.lirong.think.thread.money_demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author lirong
 * @desc
 * @date 2019/05/26 23:00
 */

public class AddMoneyThread implements Runnable {
    private CountDownLatch downLatch;
    private Account account;
    private double money;

    public AddMoneyThread(Account account, double money, CountDownLatch downLatch) {
        this.account = account;
        this.money = money;
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        account.deposit(money);
        downLatch.countDown();
    }
}
