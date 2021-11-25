package thread;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ThreadTest {

    /*
     * 1. 쓰레드는 interrupt 될 경우 해당 쓰레드가 예외 처리를 하며 종료한다. 그러므로 try-catch 를 해야 하는데 이 경우 코드가 난잡해진다.
     * 2. Runnable 의 리턴 값은 void 이다.
     */
    @Test
    void 기존의_쓰레드_apis() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    System.out.println("thread interrupted "+Thread.currentThread().getName());
                    return;
                }
                System.out.println("thread finished : "+Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable); // Thread 는 Runnable 을 매개변수로 하며, Runnable 은 FunctionalInterface 로서 익명함수나 람다로 구현 가능하다.

        thread.start();

        thread.interrupt();

        try {
            thread.join(); // 해당 쓰레드가 종료되기를 기다린다.
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("main thread finished");
    }

}
