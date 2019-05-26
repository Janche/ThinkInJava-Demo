package com.lirong.think.exception;

import java.util.*;

/**
 * @author lirong
 * @desc
 * @date 2019/05/26 17:52
 */
class Annoyance extends Exception {

}
class Sneeze extends Annoyance {

}
class Human {

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                List list  = new ArrayList();
                Set set = new HashSet();
                Map map = new HashMap();


                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}