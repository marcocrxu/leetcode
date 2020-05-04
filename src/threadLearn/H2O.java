package threadLearn;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {
    Lock lock=new ReentrantLock(true);
    volatile int HNum=0;
    Condition OCondition=lock.newCondition();
    Condition HCondition=lock.newCondition();
    Semaphore H=new Semaphore(2);
    Semaphore O=new Semaphore(0);
    public H2O() {

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try{
            while(HNum<0) {
                OCondition.await();
            }
            // releaseHydrogen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            HNum=HNum-2;
            HCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try{
            while(HNum>=2){
                HCondition.await();
            }
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            //System.out.println("HNum="+HNum);
            releaseHydrogen.run();
            HNum++;
            OCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    /*
    volatile int HNumber=0;
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        H.release();
        H.release();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire();
        synchronized (this){
            HNumber++;
            if(HNumber==2) {
                HNumber=0;
                O.release();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseHydrogen.run();
        }

    }

     */

    /*
    *
    Semaphore H=new Semaphore(2);
    Semaphore O=new Semaphore(0);
    public H2O() {

    }
    volatile int HNumber=0;
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire(2);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        H.release(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire(1);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseHydrogen.run();
        O.release(1);

    }
    * */
}
