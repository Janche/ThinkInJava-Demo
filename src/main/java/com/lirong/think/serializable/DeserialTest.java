package com.lirong.think.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author lirong
 * @desc 反序列化测试类
 * @date 2019/05/18 12:16
 */
public class DeserialTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + person);
    }
}
