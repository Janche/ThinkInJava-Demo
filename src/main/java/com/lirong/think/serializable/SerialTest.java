package com.lirong.think.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    }
}
