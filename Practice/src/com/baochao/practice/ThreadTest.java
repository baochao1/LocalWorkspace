package com.baochao.practice;

public class ThreadTest extends Thread {

  public static void main(String[] args) throws InterruptedException {
    ThreadTest threadTest = new ThreadTest();
    threadTest.start();
    ThreadTest.sleep(1000);
    threadTest.interrupt();
  }
}
