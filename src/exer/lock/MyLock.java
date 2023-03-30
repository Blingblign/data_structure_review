package exer.lock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author bling
 * @create 2022-09-28 15:09
 */
public class MyLock {
    public static synchronized void get() {
        System.out.println("线程：" + Thread.currentThread().getName() + "获得锁....");
        try {
//            TimeUnit.SECONDS.sleep(5);
            Thread.sleep(3000);
//            int i = 1/0;
            System.out.println("线程：" + Thread.currentThread().getName() + "释放锁....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void get2() {
        synchronized (this) {
            System.out.println("线程：" + Thread.currentThread().getName() + "获得锁....");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("线程：" + Thread.currentThread().getName() + "释放锁....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


