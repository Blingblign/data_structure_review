package test;

import exer.lock.MyLock;
import org.junit.Test;

/**
 * @author bling
 * @create 2022-09-28 15:13
 */
public class TestLock {
    @Test
    public void testLock() {
//        MyLock myLock = new MyLock();
        Thread thread1 = new Thread(MyLock::get);
        thread1.setName("线程一");
        Thread thread2 = new Thread(MyLock::get);
        thread2.setName("线程二");

        thread1.start();
        thread2.start();
//        myLock.get();


    }

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
//        MyLock myLock1 = new MyLock();
////        Thread thread1 = new Thread(myLock1::get);
////        thread1.setName("线程一");
////        Thread thread2 = new Thread(myLock::get);
//        thread2.setName("线程二");
//
//        thread1.start();
//        thread2.start();
//        myLock.get();
    }

}
