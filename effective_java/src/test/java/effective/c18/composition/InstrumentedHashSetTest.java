package effective.c18.composition;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentedHashSetTest{
        @Test
        void test(){
            final InstrumentedHashSet<String> insSet = new InstrumentedHashSet<>(new HashSet<>());

            insSet.add("kim");
            insSet.addAll(List.of("lee", "choi"));

            System.out.println("insSet = " + insSet.toString());
            System.out.println("insSet.getAddCount() = " + insSet.getAddCount());
        }

}