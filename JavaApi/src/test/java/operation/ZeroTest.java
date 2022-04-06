package operation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

public class ZeroTest {
    @Test
    void test(){
        double right = 5, left =0;

        System.out.println("right / left = " + right / left);
        Assertions.assertThat(Double.isInfinite(right/left)).isTrue();

        System.out.println("right % left = " + right % left);
        Assertions.assertThat(Double.isNaN(right%left)).isTrue();
    }
}
