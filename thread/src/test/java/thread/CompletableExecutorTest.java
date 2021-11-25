package thread;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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

    @Test
    void compose() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println(Thread.currentThread().getName()+"] inner code1");
            return "result";
        });

        CompletableFuture<String> future2 = future.thenCompose(s -> // future.get() 을 통한 인자가 바로 다음 스레드의 인자로 제공한다.
                CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName()+"] inner code2");
                    return s.toUpperCase();
                }));

        String s = future2.get();
        System.out.println(s);

        gracefullyDestroy(1000l, startTime); // 역시나 위의 스레드가 정리 된 후 이 스레드가 동작한다. 음. 근데 get() 이 있으므로 당연한 이야기이긴 하다.
    }

    @Test
    void combine_handle_multiple_returns_at_once(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code1");
            return "thread1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"] inner code2");
            return "thread2";
        });

        CompletableFuture<String> resultFuture = future.thenCombine(future2, (s, s2) -> s + " and " + s2);

        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Test
    void run_all_of_future_at_once_AND_insert_each_other_result() throws ExecutionException, InterruptedException {
        CompletableFuture[] array = getCompletableFutures();

        List<CompletableFuture<String>> list = Arrays.asList(array);
        CompletableFuture.allOf(array); // 동시에 여러 개의 future 를 동작한다. 그리고 각각의 future 를 채운다.

        System.out.println(array[0].get());
    }
    @Test
    void run_all_of_future_at_once_AND_insert_each_other_result_AND_stream() throws ExecutionException, InterruptedException {
        CompletableFuture[] array = getCompletableFutures();
        List<CompletableFuture<String>> list = Arrays.asList(array);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(array) // 동시에 여러 개의 future 를 동작한다. 그리고 각각의 future 를 채운다.
                .thenApply(
                        v -> list.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        for (String s : results.get()) {
            System.out.println(s);
        }
    }
    @Test
    void get_any_of_the_first_ended_thread_result() throws ExecutionException, InterruptedException {
        CompletableFuture[] array = getCompletableFutures();
        List<CompletableFuture<String>> list = Arrays.asList(array);

        for(int i=0; i<5; i++){
            CompletableFuture.anyOf(array).thenAccept(o -> System.out.println(" the first result : =========== > "+ o.toString()));
        }
    }

    @Test
    void handle_exception() throws ExecutionException, InterruptedException {
        boolean switchBtn = false;

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if(switchBtn){
                throw new IllegalStateException("예욋!");
            }
            return "hello";
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return "error";
        });
        System.out.println("switch : "+switchBtn+ " -> result : "+future.get());

    }
    @Test
    void handle_handle() throws ExecutionException, InterruptedException {
        boolean switchBtn = true;

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if(switchBtn){
                throw new IllegalStateException("예욋!");
            }
            return "hello";
        }).handle((result, ex) -> {
            if(ex!=null){
                System.out.println(ex.getMessage());
                return "error";
            }
            return result;

        });
        System.out.println("switch : "+switchBtn+ " -> result : "+future.get());

    }

    private CompletableFuture[] getCompletableFutures() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "] inner code1");
            return "thread1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "] inner code2");
            return "thread2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "] inner code2");
            return "thread3";
        });

        CompletableFuture[] array = {future, future2, future3};
        return array;
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

    void sleep(long sleep){
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
