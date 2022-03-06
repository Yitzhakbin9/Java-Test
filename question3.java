package TEST;

import java.util.Scanner;

public class question3 {
    public static void main(String[] args) {


        Scanner scr = new Scanner(System.in);
        System.out.println("Please enter 2 integer numbers:");
        int a = scr.nextInt();
        int b = scr.nextInt();

        MyThread myThreadPlus = new MyThread(new Operation("+", a, b));
        MyThread myThreadMinus = new MyThread(new Operation("-", a, b));
        MyThread myThreadMulti = new MyThread(new Operation("*", a, b));
        MyThread myThreadDivide = new MyThread(new Operation("/", a, b));


        Thread t1 = new Thread(myThreadPlus);
        Thread t2 = new Thread(myThreadMinus);
        Thread t3 = new Thread(myThreadMulti);
        Thread t4 = new Thread(myThreadDivide);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
