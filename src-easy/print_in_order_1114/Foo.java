package print_in_order_1114;

class Foo {

        public volatile int threadOrderSemaphore;

        public Foo() {
            threadOrderSemaphore = 0;
        }

        public void first(Runnable printFirst) throws InterruptedException {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                threadOrderSemaphore++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
                while(threadOrderSemaphore != 1);
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                threadOrderSemaphore++;
        }

        public void third(Runnable printThird) throws InterruptedException {
                while(threadOrderSemaphore != 2);
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
        }
}
