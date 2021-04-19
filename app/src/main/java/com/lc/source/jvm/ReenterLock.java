package com.lc.source.jvm;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock(false);

    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++){
            lock.lock();

            try{
                i ++;
                System.out.println("currentThread:" + Thread.currentThread());
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}