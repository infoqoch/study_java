package compare;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CompareTest {
    @Test
    void test(){
        Sample sample1 = new Sample();
        Sample sample2 = sample1;
        System.out.println("(sample1==sample2) = " + (sample1==sample2));
        System.out.println("(sample1 equals sample2) = " + (sample1.equals(sample2)));
        Assertions.assertThat(sample1).isEqualTo(sample2);

        Sample sampleA = new Sample();
        sampleA.name = "kim";
        Sample sampleB = new Sample();
        sampleB.name = "kim";

        System.out.println("(sampleA==sampleB) = " + (sampleA==sampleB));
        System.out.println("(sampleA equals sampleB) = " + (sampleA.equals(sampleB))); // false
        Assertions.assertThat(sampleA).isNotEqualTo(sampleB);

        Set<Sample> set1 = new HashSet<>();
        set1.add(sample1);
        set1.add(sample2);
        set1.add(sampleA);
        set1.add(sampleB);

        System.out.println("set1.size() = " + set1.size()); // 3
        Assertions.assertThat(set1).size().isEqualTo(3);
    }

    @Test
    void test2(){
        SampleEquality sample1 = new SampleEquality();
        SampleEquality sample2 = sample1;
        System.out.println("(sample1==sample2) = " + (sample1==sample2));
        System.out.println("(sample1 equals sample2) = " + (sample1.equals(sample2)));
        Assertions.assertThat(sample1).isEqualTo(sample2);

        SampleEquality sampleA = new SampleEquality();
        sampleA.name = "kim";
        SampleEquality sampleB = new SampleEquality();
        sampleB.name = "kim";
        Assertions.assertThat(sampleA).isEqualTo(sampleB);

        System.out.println("(sampleA==sampleB) = " + (sampleA==sampleB));
        System.out.println("(sampleA equals sampleB) = " + (sampleA.equals(sampleB))); // true

        Set<SampleEquality> set1 = new HashSet<>();
        set1.add(sample1);
        set1.add(sample2);
        set1.add(sampleA);
        set1.add(sampleB);

        System.out.println("set1.size() = " + set1.size());
        Assertions.assertThat(set1).size().isEqualTo(2);
    }

    static class SampleEquality{
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SampleEquality that = (SampleEquality) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Sample{
        private String name;
    }
}
