class FooBar {
    private int n;
    volatile boolean fooPrinted, barPrinted;
    Lock lock;
    Condition condition1, condition2;

    public FooBar(int n) {
        this.n = n;
        fooPrinted = true;
        barPrinted = false;
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try{
            for (int i = 0; i < n; i++) {            
                while(!fooPrinted){
                    condition2.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barPrinted = true;
                fooPrinted = false;
                condition1.signal();
            }
        }
        finally{
            lock.unlock();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try{
            for (int i = 0; i < n; i++) {
                while(!barPrinted){
                    condition1.await();
                }
                barPrinted = false;
                fooPrinted = true;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                condition2.signal();
            }
        }
        finally{
            lock.unlock();
        }
    }
}