package effective.c18.inherit;

import effective.c18.inherit.InstrumentedHashSet;
import org.junit.jupiter.api.Test;

import java.util.List;

class InstrumentedHashSetTest {
    @Test
    void test(){
        final InstrumentedHashSet<String> insSet = new InstrumentedHashSet<>();
        System.out.println("test 매서드에서 add 1개 시작");
        insSet.add("kim");

        System.out.println("test 매서드에서 addAll 2개 시작");
        insSet.addAll(List.of("lee", "choi"));

        System.out.println("insSet = " + insSet);
        System.out.println("insSet.getAddCount() = " + insSet.getAddCount());
    }

}