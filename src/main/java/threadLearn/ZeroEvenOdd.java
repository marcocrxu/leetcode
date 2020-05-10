package threadLearn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    public int i=1;
    private final Lock lock = new ReentrantLock(true);
    private int n;
    final Condition zeroCondition = lock.newCondition();
    final Condition evenCondition = lock.newCondition();
    final Condition oddCondition = lock.newCondition();
    private volatile boolean PrintOdd = false;
    private volatile boolean PrintEven = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {

            for (; i <= n;) {
                if (PrintOdd != PrintEven) {
                    zeroCondition.await();
                }
                if(i>n)
                    break;
                printNumber.accept(0);
                //System.out.println(i+" "+PrintOdd+" "+PrintEven);
                if (PrintOdd) {
                    PrintOdd = false;
                    evenCondition.signalAll();
                } else {
                    PrintOdd = true;
                    oddCondition.signalAll();
                }

            }
            oddCondition.signalAll();
            evenCondition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (; i <= n;) {
                if (!(PrintEven && !PrintOdd)) {
                    evenCondition.await();
                }
                else{
                    printNumber.accept(i++);
                    //System.out.println(PrintOdd+" "+PrintEven);
                    PrintEven = false;
                    zeroCondition.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (; i <= n; ) {
                if (!(PrintOdd && !PrintEven)) {
                    oddCondition.await();
                } else {
                    printNumber.accept(i++);
                    //System.out.println(PrintOdd+" "+PrintEven);
                    PrintEven = true;
                    zeroCondition.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
