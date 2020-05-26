package threadLearn;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    public DiningPhilosophers() {
        for(int i=0;i<number;i++){
            forks[i]=new Semaphore(1);
        }
    }
    private static final int number=5;
    public volatile int count=0;
    private Semaphore[] forks=new Semaphore[5];

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while(count<number)
            Thread.yield();
        forks[(philosopher+1)%number].acquire();
        forks[(philosopher)%number].acquire();
        count++;
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        count--;
        forks[(philosopher+1)%number].release();
        forks[(philosopher)%number].release();
    }
}
