package com.company;

import java.util.Scanner;

import static com.company.Bank.money;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan=new Scanner(System.in);
        money=scan.nextInt();
        int plus=scan.nextInt();
        int minus=scan.nextInt();
	Bank bankP=new Bank(money,plus,minus);
	Bank bankM=new Bank(money,plus,minus);
	bankP.start();
	bankM.flag=false;
	bankM.start();
    Bank.sleep(2000);
    bankP.flag=false;
    bankP.join();
    bankM.stopper();
    bankP.stopper();
    ///WTF?
    }
}
