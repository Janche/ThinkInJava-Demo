package com.lirong.think.runtime;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author lirong
 * @desc
 * @date 2019/06/13 21:25
 */
@Slf4j
public class MyThread implements Runnable {

    private InputStream in;
    public MyThread(InputStream in){
        this.in = in;
    }

    @Override
    public void run() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "GBK"));
            String line = null;
            while((line = br.readLine())!=null){
                log.debug(" inputStream: " + line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
