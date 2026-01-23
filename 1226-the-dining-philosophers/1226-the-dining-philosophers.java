class DiningPhilosophers {
    Semaphore semaphore;
    Lock[] locks;

    public DiningPhilosophers() {
        semaphore = new Semaphore(4);
        locks = new ReentrantLock[5];
        Arrays.fill(locks, new ReentrantLock());
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

                semaphore.acquire();
                int left = philosopher;
                int right = (philosopher + 1) % 5;
                Lock leftLock = locks[left];
                Lock rightLock = locks[right];
                leftLock.lock();
                rightLock.lock();
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
                leftLock.unlock();
                rightLock.unlock();
                semaphore.release();
    }
}