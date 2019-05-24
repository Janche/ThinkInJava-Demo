package com.lirong.think.review;

import org.junit.jupiter.api.Test;

/**
 * @author lirong
 * @ClassName: BasicReview
 * @Description: TODO
 * @date 2019-05-24 14:54
 */

public class BasicReview {

    @Test
    public void stringTest(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s1 == s2.intern());

        /*
        false
        true
        false
        true
        true
        * */
    }
}
