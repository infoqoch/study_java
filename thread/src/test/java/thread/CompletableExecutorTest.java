package thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class CompletableExecutorTest {


    @Test
    void completableExecutorTest1(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> { // 특정 인터페이스(Runnable, Callable)을 받는 것이 아니라 펑션 인터페이스를 받아서.... 매우 매우 좋다.
            System.out.println(Thread.currentThread().getName()+"] inner code");
            return "result";
        });
        System.out.println(Thread.currentThread().getName()+"] between future and get()"); // ExecutorService 가  invoke 와 get() 사이를 차후로 미루는 것과 다르다. 음. 확실히 한 줄로 끝나는 깔끔한 느낌이 난다!
        String s = null;
        try {
            s = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        System.out.println(s);  // 이것이 호출되는 것을 보면 이것도 get() 이전에는 메인스레드가 동작 안하는 듯
    }

    @Test
    void completableExecutor_pipeline_function(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code");
            return "result";
        }).thenApply(String::toUpperCase); // function
        String s = null;
        try {
            s = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(s);
    }

    @Test
    void pipeline_consumer(){
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code");
            return "result";
        }).thenAccept(s -> System.out.println(Thread.currentThread().getName()+"] 방가방가 결과는 : "+s)); // consumer

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("main thread destroy");
    }

    @Test
    void after_Runnable_run() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code1");
            return "result";
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"] inner code2");
            }
        });
        System.out.println("main thread destroy"); // Runnable 의 영향인지 위의 스레드보다 먼저 동작한다.
    }

    @Test
    void useAnotherThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code1");
            return "result";
        }, executorService).thenRun(() -> System.out.println(Thread.currentThread().getName()+"] inner code2"));

        System.out.println("main thread destroy"); // Runnable 의 영향인지 위의 스레드보다 먼저 동작한다.
    }

    @Test
    void useAnotherThreadPool2(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code1");
            return "result";
        }, executorService)
                .thenRunAsync(() -> System.out.println(Thread.currentThread().getName()+"] inner code2"), executorService); // 모두 then 이라서 그런지 순서가 바뀌지 않는다.

        System.out.println("main thread destroy"); // Runnable 의 영향인지 위의 스레드보다 먼저 동작한다.
    }




    Callable<String> callableMaker(String target, long sleep) {
        Callable<String> callable = ()-> {
            System.out.println("["+Thread.currentThread().getName()+"] Hello "+target);

            try {
                Thread.sleep(sleep);
                System.out.println("["+Thread.currentThread().getName()+"] Bye "+target);
                return "["+Thread.currentThread().getName()+"]good!";
            } catch (InterruptedException e) {
                System.out.println("["+Thread.currentThread().getName()+"] interrupted "+target);

            }
            return "["+Thread.currentThread().getName()+"]bad!";
        };
        return callable;
    }

    void gracefullyDestroy(long sleep ) {
        try {
            Thread.sleep(sleep);
            System.out.println("main thread destroyed");
            System.out.println("======================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void gracefullyDestroy(long sleep, long startTime) {
        gracefullyDestroy(sleep);
        long result = System.currentTimeMillis() - startTime;
        System.out.println("sleep : "+sleep+", result : "+result+", result -start : "+(result-sleep));
    }
}
