package com.company;

public class Bank extends Thread {
    boolean flag=true;
    public static int money;
    private int plus;
    private int minus;
    Bank(int mon,int monPlus,int monMinus){
        money=mon;
        this.plus=monPlus;
        this.minus=monMinus;
    }
    public int stopper(){
       return 0;
    }
    private static Object key=new Object();
    public void run() {
        while (flag) {
            synchronized (key) {
                money += plus;
                System.out.println("After plus " + money + " left");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        while (!flag) {
            synchronized (key) {
                if (money >= minus) {
                    money -= minus;
                    System.out.println("After minus " + money + " left");
                } else System.out.println("Not Enough Money");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
