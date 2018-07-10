package com.baochao.IO;

public class ThreadTest extends Thread {

  public ThreadTest (String name){
    super(name);
  }
  
  public void run (){
    for (int i = 0; i < 10; i++) {
      System.out.println(this.getName() + i);
      
    }
  }
  
  public static void main(String[] args) {
    ThreadTest test1 = new ThreadTest("zhangsan");
    ThreadTest test2 = new ThreadTest("lisi");
    
    test1.start();
    test2.start();
  }
}
