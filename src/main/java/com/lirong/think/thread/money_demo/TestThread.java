package com.lirong.think.thread.money_demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lirong
 * @desc
 * @date 2019/05/26 23:01
 */

public class TestThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Account account = new Account();
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new AddMoneyThread(account, 1,latch));
        }

        executorService.shutdown();

        while(!executorService.isTerminated()) {}

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("账户余额: " + account.getBalance());
    }
}
