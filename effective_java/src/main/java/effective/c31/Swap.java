package effective.c31;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Swap {
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

//    public static void swapOld(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i)));
//    }

    @Test
    void test(){
        // 첫 번째와 마지막 인수를 스왑한 후 결과 리스트를 출력한다.
        List<Integer> argList = Arrays.asList(3, 45, 6, 32, 234, 46);

//        swapOld(argList, 0, argList.size() - 1);
        swap(argList, 0, argList.size() - 1);

        System.out.println(argList);
    }
    }
