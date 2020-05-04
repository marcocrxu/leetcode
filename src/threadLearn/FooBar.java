package threadLearn;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private volatile boolean count=false;
    //private Semaphore first=new Semaphore(0);
    //private Semaphore second=new Semaphore(1);
    private Lock lock=new ReentrantLock(true);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            lock.lock();
            try{
                if(!count){
                    i++;
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    count=true;
                }

            }finally {
                lock.unlock();
            }
            //while(count){
            //   Thread.yield();
            //}
            //second.acquire();

            //first.release();
            //addCount();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {
            //first.acquire();

            lock.lock();
            try {
                if(count){
                    count=false;
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    i++;
                }
            }finally {
                lock.unlock();
            }

            //second.release();
        }
    }
}
