class DiningPhilosophers {
    private Semaphore participants;
    private ReentrantLock[] locks;
    public DiningPhilosophers() {
        participants = new Semaphore(4);
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
            
            int left = philosopher;
            int right= (philosopher+1)%5;
            participants.acquire();
            locks[left].lock();
            pickLeftFork.run();
            locks[right].lock();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            locks[left].unlock();
            putRightFork.run();
            locks[right].unlock();
            participants.release();
        
    }
}