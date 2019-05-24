package com.lirong.think.serializable;

import java.io.*;

/**
 * @author lirong
 * @ClassName: CloneUtils
 * @Description: TODO
 * @date 2019-05-24 15:14
 */

public class CloneUtils {

    private CloneUtils() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        // oos.close();

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        // ois.close();
        return (T) ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }

    public static void main(String[] args) {

        Person person = new Person(1, "Janche");
        try {
            Person clonePerson = CloneUtils.clone(person);
            System.out.println(person == clonePerson);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
