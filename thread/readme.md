# 쓰레드
## 이번 기회에...
- 이번 기회에 쓰레드에 대해 정리할 수 있었다. 솔직히 정말로 많은 것을 배울 수 있었다.
- 쓰레드를 다루는 기술은 대략 세 가지 있는 것 같다.
- 각 도구 마다의 특징 때문에 메인 쓰레드와의 관계가 발생하고, 
- 쓰레드 간 인터페이스가 달라서
  - 콜백에 대한 정의 방법으로의 익명함수, 람다 등과 
  - 메서드나 스트림의 활용
  - 리턴의 존재 유무에 대해 배웠다.

## 메인스레드와의 경합과 리턴 값 
- 스레드의 다양한 인터페이스는 크게 두 가지로 나눌 수 있는 것 같다. 
  - 메인스레드와 경합하며 리턴 값이 없거나 -> Runnable 
  - 메인스레드의 흐름에는 동기적으로 동작하며 리턴 값이 있거나 -> Callable, Future
- 생각해보면 return 값이 있으면 당연하게도 그것의 값이 나오기를 기다려야 한다. 반대로 리턴 값이 없으면 메인스레드와 함께 동작하면 될 것이다.
- 하지만 메인스레드와 경합하지 않기를 바랄 수 있다. 이 경우 
  - Thread 는 join() 을 사용하며
  - 다른 api 는 Callable 이나 Future 를 쓰면 된다.
- 반대로 메인스레드와 경합하기를 바라면, 
  - Runnable 을 사용하며
  - submit 등으로 runnable 을 넣는다.

## Thread 로부터 비교한  ExecutorService
- Thread 와 ExecutorService 의 가장 큰 차이는 역시 리턴 값에 있다. 리턴값을 원하면 Callable 을 데이타타입으로 하여 Future 로 리턴 받는다.
- 동시에 여러 개의 쓰레드를 동시에 조작할 수 있다.
  - Executors.newFixedThreadPool(int pools) 를 통해 쓰레드의 갯수를 정의하고 
  - invokeAll 을 통해 다수의 쓰레드를 한 번에 넣으며
  - 해당 리턴 값을 get 하여 collection 으로 조작할 수 있다. 
- invokeAny 를 통해 여러 스레드를 경합 시켜, 가장 빠른 값을 조작할 수 있다.  
- invoke() 와 get() 사이, get() 이후의 메인 스레드의 코드는 해당 스레드풀의 동작이 종료되기 전까지 동작하지 않는다. 음. get() 이후 부터는 이해가 가는데 왜 invoke()와 get() 사이는 멈추지?

## ExecutorService 로부터 비교한 CompletableExecutor
- 완전한 실행자란 이름에 걸맞게 매우 다양한 기능을 가진다.
- 가장 아름다운 기능은 스프링이 기본적으로 제공하는 함수를 사용할 수 있다. Function 과 Supplier 를 사용한다.
- invoke - get 의 이해할 수 없는 동작과 달리, Future 는 단순하게 정의를 하고, get() 을 통해 동작한다. 그러니까 get() 전의 코드는 잘 동작한다.
- 파이프라인이 훌륭하게 동작한다. Function -> Supplier -> Function 등의 리턴한 값을 활용하며 계속되는 쓰레드의 흐름을 생성할 수 있다.
- 예외 처리가 아름답다. 파이프라인에 exceptional 혹은 handler (BiFunction<Return, Exception, Return>) 의 형태를 가질 수 있다. 
- 쓰레드풀 동작 후 리턴을 다루는 방식이 다르다.
  - ExecutorService 의 invokeAll 는 각 각의 스레드의 결과물을 collection 형태로 리턴하는 것에 대비하여, 
  - CompletableExecutor 의 allOf 는 리턴 값이 사실상 존재하지 않고 각각의 future 에 리턴 값을 넣는다.
    - 그러므로 allOf()로 실행 후 각각의 future 에서 get() 으로 값을 호출할 수 있고,
    - 쓰레드 종료 즉시 데이타를 다뤄야 한다면, allOf().then(void -> futures.get()....) 의 형태로 진행한다. 이때 void 는 쓰레드가 종료되고 리턴한 아무것도 아닌 값으로 일종의 그냥 신호 정도로 사용한다.  

## interrupt 
- 보통 쓰레드는 InterruptException 이란 식으로 예외처리를 한다.
- 각 각의 api 는 쓰레드를 gracefully 종료하거나 강제 종료하는 기능이 있다. shutdown, shutdownnow, interrupt 등...
- 무한 루프로 동작하는 스레드의 경우, catch 에서 예외를 전파하는 방식으로 코딩을 하더라도, 인터럽트가 동작하지 않는 경우가 있다. 이런 경우 return; 을 통해 반복문을 멈추도록 해야 한다.   

## 나아가며
- 쓰레드에 대하여 정말로 많이 이해할 수 있었다. 익명함수, 람다, 제너릭 이후 쓰레드를 공부하니 이해에 큰 도움이 되었다. 이전에는 해도 잘 이해가 안갔는데. 
- 쓰레드와 메인쓰레드와의 관계에 대해 더 이해할 수 있어서 조금 덜 두렵게 조작할 수 있겠다는 생각을 했다.