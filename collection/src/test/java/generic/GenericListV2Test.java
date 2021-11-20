package generic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class GenericListV2Test {

    @Test
    void dynamicStorage(){
        GenericListV2<Integer> intList = new GenericListV2<>();
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);

        System.out.println(intList.size());
        assertThat(intList.size()).isEqualTo(5);
    }

}