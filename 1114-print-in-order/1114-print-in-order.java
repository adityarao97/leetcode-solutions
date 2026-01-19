class Foo {
    private volatile boolean firstDone, secondDone;
    private Lock lock;
    private Condition condition1, condition2; 

    public Foo() {
        firstDone = secondDone = false;
        lock = new ReentrantLock();
        condition1 = condition2 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstDone = true;
            condition1.signal();
        }
        finally{
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(!firstDone){
                condition1.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondDone = true;
            condition2.signal();
        }
        finally{
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while(!secondDone){
                condition2.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
        finally{
            lock.unlock();
        }
    }
}