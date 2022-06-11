package annotation;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnnotationCompareTest {

    @Test
    void test_string_value(){
        // given
        List<Annotation> targets = new ArrayList<>();
        final Field[] fields = Tester.class.getDeclaredFields();
        for (Field field : fields) {
            final Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                targets.add(annotation);
            }
        }

        // when
        final Annotation anno0 = targets.get(0);
        final Annotation anno1 = targets.get(1);
        final Annotation anno2 = targets.get(2);

        assertThat(anno0 == anno1).isFalse();
        assertThat(anno0.equals(anno1)).isTrue();
        System.out.println("(anno0 == anno1) = " + (anno0 == anno1));
        System.out.println("anno0.equals(anno1) = " + anno0.equals(anno1));


        assertThat(anno0 == anno2).isFalse();
        assertThat(anno0.equals(anno2)).isFalse();
        System.out.println("(anno0 == anno2) = " + (anno0 == anno2));
        System.out.println("anno0.equals(anno2) = " + anno0.equals(anno2));
    }
    

    @AllArgsConstructor
    public static class Tester{
        @TestAnno("hi")
        private String a;
        @TestAnno("hi")
        private String b;
        @TestAnno("good")
        private String c;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface TestAnno{
        String value();
    }
}

