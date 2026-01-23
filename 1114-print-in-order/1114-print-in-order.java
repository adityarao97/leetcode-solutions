class Foo {

    Semaphore semaphoreFirst, semaphoreSecond, semaphoreThird;
    public Foo() {
        semaphoreFirst = new Semaphore(1);
        semaphoreSecond = new Semaphore(0);
        semaphoreThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphoreFirst.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphoreSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphoreSecond.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphoreThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphoreThird.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphoreFirst.release();
    }
}