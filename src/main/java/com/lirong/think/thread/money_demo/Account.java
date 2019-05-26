package com.lirong.think.thread.money_demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lirong
 * @desc
 * @date 2019/05/26 22:59
 */
public class Account {
    /**
     * 账户余额
     */
    private double balance;

    // private Lock accountLock = new ReentrantLock();

    /**
     * 存款
     * @param money 存入金额
     */
    public  void deposit(double money) {
        // accountLock.lock();
        double newBalance = balance + money;
        try {
            // 模拟此业务需要一段处理时间
            Thread.sleep(2);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
        // accountLock.unlock();
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }
}
