package com.lirong.think.collection_iterator;

import java.util.*;

/**
 * @author lirong
 * @ClassName: CollectionSequence
 * @Description: TODO
 * @date 2019-04-18 17:19
 */

public class CollectionSequence implements Iterator {

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {


        return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public Object next() {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 6, 7, 8, 9);
        list.forEach(System.out::print);
        List<Integer> ls = new ArrayList<>(list);
        Collections.shuffle(ls, new Random());
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();
        ls.forEach(System.out::print);
    }
}
