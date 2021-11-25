package thread;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/*
*
* ExecutorService 는 Runnable 과 Callable, Future 를 사용한다.
* Runnable 은 submit() 을 사용하며 쓰레드가 메인쓰레드와 동시에 동작한다.
* Callable 은 invoke() -> get() 으로 사욯아며, void 가 아닌 return 데이터타입을 가질 수 있다.
*  -> 다만 get() 이 호출되기 전까지 메인쓰레드는 동작하지 않는다. 그러니까 해당 풀에서는 멀티스레드로 비동기적으로 동작하지만 메인스레드 입장에서는 동기적으로 작동한다. 마치 thread.join() 처럼!
*  -> invoke() 와 get() 사이의 코드 역시도 동작하지 않는다. 음. 이 부분은 솔직히 좀 신기하다. 왜지?
*  -> 암튼 쓰레드가 자신이 호출하는 요구에는 비동기 멀티스레드로 동작하지만 메인스레드 입장에서 동기적으로 동작하는 것이 흥미로웠다. 이런 부분을 통해 상당히 조심스러운 코딩이 가능할 것 같다.
*
*/
public class ExecutorServiceTest {

    @Test
    void ExecutorService_with_Runnable() {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();

//        executor.submit(runnableMaker("hi", 1000));

        executor.submit(runnableInfinitiveMaker("hi", 50));

        executor.shutdown(); // 반복문은 멈추지 못한다.

//        executor.shutdownNow(); // 강제로 죵로된다. 예외처리 된다.

        gracefullyDestroy(1000, startTime); // submit 은 다른 스레드와 함께 동작하는 것으로 보인다. executor 를 interrupt 하지 않는 이상, 테스트 자체가 끝나는 때(gracefullyDestroy 가 죵료 될 때) 함께 끝난다.

    }

    @Test
    void ExecutorService_with_Multi_Runnable() {
        long startTime = System.currentTimeMillis();

        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Runnable> list =  Arrays.asList(runnableMaker("1000", 1000l), runnableMaker("2000", 2000l), runnableMaker("500", 500l));

        for(Runnable r : list) {
            executor.submit(r);
        }

        gracefullyDestroy(1000, startTime); // submit 은 다른 스레드와 함께 동작하는 것으로 보인다. executor 를 interrupt 하지 않는 이상, 테스트 자체가 끝나는 때(gracefullyDestroy 가 죵료 될 때) 함께 끝난다.

    }

    @Test
    void ExecutorService_with_Multi_Callable() {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> list =  Arrays.asList(callableMaker("1000", 1000l), callableMaker("2000", 2000l), callableMaker("500", 500l));

        try {
            List<Future<String>> returns = executor.invokeAll(list);

            System.out.println("before get() method called");

            List<String> returnStrList = returns.stream().map(c -> {
                try {
                    return c.get(); // get 이 호출되기 전까지 자신 미만의 코드가 동작하지 않는다.
                } catch (InterruptedException | ExecutionException e) {
                    return null;
                }
            }).collect(Collectors.toList());

            System.out.println("after get() method called");

            for(String s: returnStrList) {
                System.out.println(s);
            }
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("I don't wanna wait for thread done!!! I just wanna speak out now!");

        gracefullyDestroy(2000, startTime); // 슬립하는만큼 대기한다. 그러니까 스레드 동작 자체가 get() 이후에 진행됨을 확인할 수 있다. 결과적으로 ExecutorService 는 자신들의 스레드가 우선되고 다 끝나고 나머지가 진행된다. 그러니까 이게 필요 없네!
    }

    @Test
    void ExecutorService_with_Multi_Callable_Invoke_Any() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> list =  Arrays.asList(callableMaker("1000", 1000l), callableMaker("2000", 2000l), callableMaker("500", 500l));

        try {
            String returns = executor.invokeAny(list);

            System.out.println(returns);

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("예외");
        } 
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

    Runnable runnableMaker(String target, long sleep) {

        Runnable runnable = ()->{
            System.out.println("["+Thread.currentThread().getName()+"] Hello "+target);

            try {
                Thread.sleep(sleep);
                System.out.println("["+Thread.currentThread().getName()+"] Bye "+target);
            } catch (InterruptedException e) {
                System.out.println("["+Thread.currentThread().getName()+"] interrupted "+target);
//                return;
            }

        };

        return runnable;
    }

    Runnable runnableInfinitiveMaker(String target, long sleep) {

        Runnable runnable = ()->{
            while(true){
                System.out.println("["+Thread.currentThread().getName()+"] Hello infinitive "+target);

                try {
                    Thread.sleep(sleep);
                    System.out.println("["+Thread.currentThread().getName()+"] Bye infinitive "+target);
                } catch (InterruptedException e) {
                    System.out.println("["+Thread.currentThread().getName()+"] interrupted infinitive "+target);
                return; // 반복문을 없애기 위하여 필요하다. 반복문이 아닐 경우 그냥 끝난다.
                }
            }
        };

        return runnable;
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
