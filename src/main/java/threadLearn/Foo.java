package threadLearn;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private volatile int count=1;
    private Semaphore one=new Semaphore(0);
    private Semaphore two=new Semaphore(0);
    public Foo() {

    }

    private synchronized void addCount(){
        count++;
    }


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        one.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        two.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        two.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
