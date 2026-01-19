class H2O {

    Semaphore hSemaphore, oSemaphore;
    
    public H2O() {
        hSemaphore = new Semaphore(2);
        oSemaphore = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hSemaphore.release(2);
    }
}