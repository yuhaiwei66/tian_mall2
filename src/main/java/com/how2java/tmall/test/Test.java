package com.how2java.tmall.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author hahahaha
 * @date 2017/11/16
 */
public class Test {

    public int value=100;
    public void increment2() {
        value--;
//        System.out.println(value);
    }
    public void increment() {
        value++;
//        System.out.println(value);
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        List list = new ArrayList();








        int n = 100;
        Thread[] addThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.increment();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            a.start();
            addThreads[i] = a;

        }
        Thread[] reduceThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.increment2();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            b.start();
            reduceThreads[i] = b;

        }
        //等待所有增加线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //等待所有减少线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(test.value);
    }
}

