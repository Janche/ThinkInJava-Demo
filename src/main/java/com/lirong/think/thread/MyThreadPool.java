package com.lirong.think.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lirong
 * @desc
 * @date 2019/05/19 20:41
 */
public class MyThreadPool {

    /** 默认线程数量 */
    private final static int THREAD_COUNT = 5;

    /** 默认任务队列的容量 */
    private final static int DEFAULT_CAPACITY = 100;

    /** 阻塞队列 */
    private final BlockingQueue<Runnable> workQueue;

    /**  线程列表 */
    private ArrayList<Thread> threads;

    /** 核心线程池 */
    private int corePoolSize;

    /** 队列容量 */
    private int capacity;

    public MyThreadPool(int corePoolSize,int capacity){

        this.corePoolSize = corePoolSize;
        if(corePoolSize <= 0){
            this.corePoolSize = THREAD_COUNT;
        }
        this.capacity = capacity;
        if(capacity<=0){
            this.capacity = DEFAULT_CAPACITY;
        }
        /** 初始化任务队列 */
        workQueue = new ArrayBlockingQueue<>(this.capacity);

        /** 初始化工作线程 */
        threads = new ArrayList<>(this.corePoolSize);
        for (int i = 0; i < this.corePoolSize; i++) {
            WorkThread workThread = new WorkThread();
            threads.add(workThread);
            workThread.start();
        }
    }

    /**
     * 加入任务
     * @param task 任务
     */
    public void execute(Runnable task) {
        try {
            this.workQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 工作线程
     */
    class WorkThread extends Thread{
        Runnable task = null;
        @Override
        public void run() {

            try {
                while(!isInterrupted()){
                    /** 阻塞队列在这里阻塞等待任务的加入 */
                    task = workQueue.take();
                    task.run();
                    task = null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 销毁线程池
     */
    public void destroy(){
        /** 遍历终止所有工作线程 */
        Iterator it = this.threads.iterator();
        while(it.hasNext()){
            Thread t = (Thread) it.next();
            t.interrupt();
            it.remove();
        }
        /** 清空任务队列 */
        workQueue.clear();
    }

    @Override
    public String toString() {
        return "WorkThread number:"+this.corePoolSize+" wait task number:"+workQueue.size();
    }
}
