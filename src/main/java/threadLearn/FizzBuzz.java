package threadLearn;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    //ÓÃ¹«Æ½Ëø
    private Lock lock=new ReentrantLock(true);
    private Condition divideBy3=lock.newCondition();
    private Condition divideBy5=lock.newCondition();
    private Condition divideBy15=lock.newCondition();
    private Condition other=lock.newCondition();
    private volatile int cnt=1;



    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (cnt <= n) {
            lock.lock();
            try {
                if (cnt % 3 != 0 || cnt % 15 == 0) {
                    divideBy3.await();
                }
                if (cnt > n) {
                    divideBy5.signalAll();
                    divideBy15.signalAll();
                    other.signalAll();
                    return;
                }
                System.out.println(1 + " " + cnt);
                printFizz.run();
                cnt++;
                if (cnt % 15 == 0)
                    divideBy15.signal();
                else if (cnt % 3 == 0)
                    divideBy3.signal();
                else if (cnt % 5 == 0)
                    divideBy5.signal();
                else
                    other.signal();
            } finally {
                lock.unlock();
            }
        }
        divideBy5.signalAll();
        divideBy15.signalAll();
        other.signalAll();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=0;i<=n;i+=5) {
            lock.lock();
            try {
                if (i % 5 != 0 || i % 15 == 0)
                    divideBy5.await();
                System.out.println(2 + " " + cnt);
                printBuzz.run();
                cnt++;
                if (cnt % 15 == 0)
                    divideBy15.signal();
                else if (cnt % 3 == 0)
                    divideBy3.signal();
                else if (cnt % 5 == 0)
                    divideBy5.signal();
                else
                    other.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(cnt<=n) {
            lock.lock();
            try {
                if (cnt % 15 != 0)
                    divideBy15.await();
                if(cnt>n){
                    divideBy5.signalAll();
                    divideBy3.signalAll();
                    other.signalAll();
                    return;
                }
                System.out.println(3 + " " + cnt);
                printFizzBuzz.run();
                cnt++;
                if (cnt % 15 == 0)
                    divideBy15.signal();
                else if (cnt % 3 == 0)
                    divideBy3.signal();
                else if (cnt % 5 == 0)
                    divideBy5.signal();
                else
                    other.signal();
            } finally {
                lock.unlock();
            }
        }
        divideBy5.signalAll();
        divideBy3.signalAll();
        other.signalAll();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(cnt<=n) {
            lock.lock();
            try {
                if (cnt % 5 == 0 || cnt % 3 == 0)
                    other.await();
                if(cnt>n){
                    divideBy5.signalAll();
                    divideBy3.signalAll();
                    divideBy15.signalAll();
                    return;
                }
                System.out.println(4 + " " + cnt);
                printNumber.accept(cnt);
                cnt++;
                System.out.println(4 + "  " + cnt);
                if (cnt % 15 == 0)
                    divideBy15.signal();
                else if (cnt % 3 == 0)
                    divideBy3.signal();
                else if (cnt % 5 == 0)
                    divideBy5.signal();
                else
                    other.signal();
            } finally {
                lock.unlock();
            }
        }
        divideBy5.signalAll();
        divideBy3.signalAll();
        divideBy15.signalAll();
    }
}