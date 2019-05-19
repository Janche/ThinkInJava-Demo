package com.lirong.think.thread;

/**
 * @author lirong
 * @desc
 * @date 2019/05/19 21:36
 */

public class TestThreadPool {

    public static void main(String[] args) {
        /** 创建一个有5个核心线程和100个线程池等待队列的线程池对象*/
        MyThreadPool myThreadPool = new MyThreadPool(5,6);
        /** 加入8个任务 */
        for (int i = 0; i < 18; i++) {
            myThreadPool.execute(new Task("TaskName"+(i+1)));
            System.out.println(myThreadPool.toString());
        }

        //...
        // System.out.println(myThreadPool.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThreadPool.toString());
       myThreadPool.destroy();
    }
}
