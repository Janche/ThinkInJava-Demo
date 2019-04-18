package com.lirong.think.queue;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * @author lirong
 * @ClassName: QueueDemo
 * @Description: TODO
 * @date 2019-04-18 16:14
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        while(queue.peek() != null){
            System.out.print(queue.poll() +" ");
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i+10));
        }
        printQ(queue);

        Queue<Character> qc = new LinkedList<>();
        for (char s: "ThinkInJava".toCharArray()) {
            qc.offer(s);
        }
        printQ(qc);

        List<String> strings = Arrays.asList("ASEDFSDFGSDFSADFGHJK".split(""));
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.addAll(strings);
        printQ(pq);
    }
}
