package stream;

import com.sun.source.tree.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTest {
    List<OnlineClass> springClasses = new ArrayList<>();
    List<OnlineClass> javaClasses = new ArrayList<>();
    List<List<OnlineClass>> keesunEvents = new ArrayList<>();

    @BeforeEach
    void init(){
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);
}

    @Test
    void test1(){
        System.out.println("spring 으로 시작하는 수업");
        // TODO
        List<OnlineClass> spring = springClasses.stream().filter(onlineClass -> onlineClass.getTitle().startsWith("spring")).collect(Collectors.toList());
        spring.forEach(v -> System.out.println(v.getTitle()));

    }

    @Test
    void test2(){
        System.out.println("close 되지 않은 수업");
        // TODO
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(v -> System.out.println(v.getTitle()+" : "+v.isClosed()));
    }

    @Test
    void test3(){
        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO
        List<String> collect = springClasses.stream().map(OnlineClass::getTitle).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    // 플랫팅 : 두 개의 리스트를 열어서 하나의 리스트 묶음으로 만든다.
    @Test
    void test4(){
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO
        keesunEvents.stream().flatMap(Collection::stream).forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

    }

    @Test
    void test5(){
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO
        Stream<Integer> iterate = Stream.iterate(10, i -> i + 1); // 10에서 1씩 더하는 스트림.
        iterate.skip(10)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    void test6(){
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        // TODO
        boolean test = javaClasses.stream().anyMatch(onlineClass -> onlineClass.getTitle().contains("Test"));
        System.out.println(test);
    }

    @Test
    void test7(){
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        // TODO
        List<OnlineClass> spring = springClasses.stream().filter(onlineClass -> onlineClass.getTitle().contains("spring")).collect(Collectors.toList());

    }

}