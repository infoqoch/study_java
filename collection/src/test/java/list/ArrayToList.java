package list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    @Test
    void 원시타입배열_리스트(){
//        final List<Integer> ints1 = Arrays.asList(new int[]{1, 2, 3, 1, 4, 1, 2}); // 컴파일 에러

        final List<Integer> ints1 = Arrays.asList(new Integer[]{1, 2, 3, 1, 4, 1, 2});
        Assertions.assertThat(ints1).size().isEqualTo(7);

//        final ArrayList<String> strs1 = (ArrayList<String>) Arrays.asList("안녕", "반가워"); // ClassCastException

        final ArrayList<String> strs2 = new ArrayList<>(Arrays.asList("안녕", "반가워"));
        Assertions.assertThat(strs2).size().isEqualTo(2);
    }
}
