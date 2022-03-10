package effective.c30;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class GenericMethod {

    public static Set union1(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    @Test
    void testV1(){
        // given
        Set s1 = new HashSet();
        s1.add(1234);
        s1.add("kim");

        Set s2 = new HashSet();
        s2.add(4567);
        s2.add("lee");

        // when
        final Set result = union1(s1, s2);

        // then
        for (Object o : result) {
            System.out.println("o = " + o);
            System.out.println("o.getClass() = " + o.getClass());
        }
    }

    public static <E> Set<E> union2(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    @Test
    void testV2_legacy(){
        // given
        Set s1 = new HashSet(); // 제네릭 메서드로 변경하더라도 제네릭을 선언하지 않은 기존의 코드가 정상적으로 동작한다.
        s1.add(1234);
        s1.add("kim");

        Set s2 = new HashSet();
        s2.add(4567);
        s2.add("lee");

        // when
        final Set result = union2(s1, s2);

        // then
        for (Object o : result) {
            System.out.println("o = " + o);
            System.out.println("o.getClass() = " + o.getClass());
        }
    }

    @Test
    void testV2_type(){
        // given
        Set<Integer> s1 = new HashSet<>();
        s1.add(1234);
        // 컴파일 에러가 발생한다.
        // s1.add("kim");

        Set<Integer> s2 = new HashSet<>();
        s2.add(4567);
        // s2.add("lee");

        // when
        final Set<Integer> result = union2(s1, s2);

        // then
        for (Object o : result) {
            System.out.println("o = " + o);
            System.out.println("o.getClass() = " + o.getClass());
        }
    }
}
