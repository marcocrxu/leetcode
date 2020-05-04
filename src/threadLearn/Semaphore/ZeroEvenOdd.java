package threadLearn.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    public int i=1;
    private int n;
    private Semaphore zero=new Semaphore(1);
    private Semaphore even=new Semaphore(0);
    private Semaphore odd=new Semaphore(0);
    private volatile boolean PrintOdd = false;
    private volatile boolean PrintEven = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(;i<n;){
            zero.acquire();
            printNumber.accept(0);
            if(PrintOdd&&PrintEven)
                even.release();
            else
                odd.release();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(;i<n;){
            even.acquire();
            printNumber.accept(i++);
            PrintEven=false;PrintOdd=false;
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(;i<n;){
            odd.acquire();
            printNumber.accept(i++);
            PrintOdd=true;PrintEven=true;
            zero.release();
        }
    }
}
