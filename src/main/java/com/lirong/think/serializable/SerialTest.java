package com.lirong.think.serializable;

import java.io.*;

/**
 * @author lirong
 * @desc 序列化测试类
 * @since 2019/05/18 12:09
 */
public class SerialTest {
    public static void main(String[] args) throws IOException {
        Person person = new Person(1234, "Janche");
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Person person1 = (Person) ois.readObject();
            ois.close();
            System.out.println(person1);
            System.out.println(person == person1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
