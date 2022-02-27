package effective.c02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NutritionFactsTest {
    @Test
    void test(){
        // given
        final int calories = 12;
        final NutritionFacts result = new NutritionFacts
                .Builder(1, 2)
                .calories(calories)
                .fat(454)
                .sodium(345)
                .build();

        // then
        System.out.println("result = " + result);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getFat()).isGreaterThan(0);
        Assertions.assertThat(result.getCarbohydrate()).isEqualTo(0);
        Assertions.assertThat(result.getCalories()).isEqualTo(calories);
    }
}