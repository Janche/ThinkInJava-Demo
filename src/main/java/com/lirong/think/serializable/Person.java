package com.lirong.think.serializable;

import java.io.Serializable;

/**
 * @author lirong
 * @desc 序列化类
 * @date 2019/05/18 12:04
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    // private transient int age = 7;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " +
                // "age:"+age+
                ", id: "+ id +
                ", name: " + name;
    }
}