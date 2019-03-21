import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Title:
 * </p>
 * Description:
 * <p>
 *
 * @author jerry
 * @version Date: 2019/3/13
 */
public class Test {
    private static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
//        try {
//            Test t = new Test();
//            t.printNum();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(22 & 1);
    }

    public void printNum() throws Exception {
        new Thread(new NumRunner(1), "线程1").start();
        Thread.sleep(1);
        new Thread(new NumRunner(2), "线程2").start();
        Thread.sleep(1);
        new Thread(new NumRunner(0), "线程3").start();
    }

    private class NumRunner implements Runnable {
        private int num;

        public NumRunner(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (count < 100) {
                synchronized (lock) {
                    try {
                        if (count % 3 == num) {
                            System.out.println(Thread.currentThread().getName() + " " + count++);
                            lock.notifyAll();
                        }

                        if (count < 100) {
                            lock.wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
