package stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    List<String> list = new ArrayList<>();

    @BeforeEach
    void init(){
        list.add("kim");
        list.add("lee");
        list.add("kang");
        list.add("bae");
    }
    /*
    * 스트림은 데이터를 저장하는 저장소가 아니다.
    * 스트림은 소스를 변경하지 않는다. functional on nature. stream 으로 조작한 것은 stream 으로 리턴한다. 해당 소스는 그대로 남아 있다.
    * 스트림으로 처리하는 데이터는 한 번만 처리한다.
    * 스트림의 처리 대상은 무제한일 수 있고, 그것을 short circit 으로 제한할 수 있다.
    * 메서드는 크게 terminal 오페러이션과 중계 오퍼레이션으로 나눌 수 있다. 중계 오퍼레이션은 스트림으로 리턴하며 여러개를 가질 수 있으며 기본적으로 lazy 하다. 종료 오퍼레이션은 스트림이 아닌 다른 데이터타입으로 리턴하며 1회 호출 된다.
    * 손 쉽게 병렬 처리 가능하다.
    */

    @Test
    void 손쉽게_병렬처리_가능하다(){ // Spliterator 를 활용하여 다중 스레드를 통한 병렬 처리가 가능하다. 대부분의 경우 그냥 stream 을 활용하고, 대체로 데이터가 매우 방대할 때 시도해볼만 하다. 

        List<String> collect = list.parallelStream()
                .map(s->{
                    System.out.println(s +" " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
    }
    @Test
    void 스트림은_lazy하다(){
        list.stream().map(s -> {
            System.out.println(s); // stream 만 있을 경우 내부 로직을 실행하지 않는다. 그저 파이프라인을 만들 뿐이다.
            return s.toUpperCase();
        });
        System.out.println("=======");
        List<String> collect = list.stream()
                .map(s -> {
                    System.out.println(s); // terminal operation 을 사용할 경우에만 실제의 로직이 실행된다.
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());

    }

    @Test
    void 스트림은_소스를_변경하지_않는다(){

        List<String> collect = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(list); // 변동이 없음
        System.out.println("====");
        System.out.println(collect);
    }



}
