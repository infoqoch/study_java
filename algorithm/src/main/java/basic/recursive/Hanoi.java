package basic.recursive;

import basic.stack.GenericDoubleStack;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {

    // 모범답안
    public static void move(int no, int from, int to) {
        if (no > 1) {
            move(no - 1, from, 6 - from - to);
        }
        System.out.printf("원반[%d]을 %s기둥에서 %s기둥으로 옮김\n", no, from, to);
        if (no > 1) {
            move(no - 1, 6 - from - to, to);
        }
    }

    @Test
    void 테스트() {
        move(3, 1, 3);
    }

    @Getter
    @ToString
    static class HanoiDisc {
        private int idx;
        private int from;
        private int to;

        public HanoiDisc(int idx, int from, int to) {
            this.idx = idx;
            this.from = from;
            this.to = to;
        }

    }

    @Test
    void 모범답안_리스트_테스트() {
        move(3, 1, 3);
        final List<HanoiDisc> result = moveList(3, 1, 3);
        System.out.println("=============");
        result.stream().forEach(disc -> {
            System.out.printf("원반[%d]을 %s기둥에서 %s기둥으로 옮김\n", disc.getIdx(), disc.getFrom(), disc.to);
        });

    }

    // 모범답안 리스트 저장
    public static List<HanoiDisc> moveList(int no, int from, int to) {
        List<HanoiDisc> result = new ArrayList<>();
        moveList(result, no, from, to);
        return result;
    }

    public static void moveList(List<HanoiDisc> list, int no, int from, int to) {
        if (no > 1) {
            moveList(list, no - 1, from, 6 - from - to);
        }
        list.add(new HanoiDisc(no, from, to));
        if (no > 1) {
            moveList(list, no - 1, 6 - from - to, to);
        }
    }


    /*
    하노이의 핵심은 자기 자신보다 하나 적은 갯수(5개면 4개)가 중간으로 가고, 남은 것을 반대편으로 옮기는 것이다.
    그러니까, stack(1:n-1)이 중간으로 가고, stack(n)이 오른쪽으로 간 후, stack(1:n-1)이 오른쪽으로 간다.
    한편, stack(1:n-1)이 이동하기 위해서는,
    stack(1:n-2)이 중간으로 가고, stack(n-1)이 왼쪽으로 간 후, stack(1:n-2)이 왼쪽으로 간다.
    이를 반복하다 보면, stack(1:1, 결국 1)이 중간으로 가고, stack(2)가 오른쪽에 가고, stack(1)이 오른쪽으로 간다.
    */
    public static void move1(int n, int from, int to) {
        if (n > 1) {
            move1(n - 1, from, 6 - from - to);
        }
        System.out.printf("%d이 %d에서 %d로 간다\n", n, from, to);

        if (n > 1) {
            move1(n - 1, 6 - from - to, to);
        }
    }


    @Test
    void 테스트2() {
        move1(3, 1, 3);
    }


    // 모범답안 리스트 저장
    public static List<HanoiDisc> moveListNoTail(int no, int from, int to) {
        List<HanoiDisc> result = new ArrayList<>();
        moveListNoTail(result, no, from, to);
        return result;
    }

    public static void moveListNoTail2(List<HanoiDisc> list, int no, int from, int to) {
        while (no > 0) {
            if (no > 1) {
                moveListNoTail2(list, no - 1, from, 6 - from - to);
            }
            list.add(new HanoiDisc(no, from, to));
            System.out.printf("%d이 %d에서 %d로 간다\n", no, from, to);
            no--;
            int temp = to;
            to = from;
            from = temp;
        }
    }

    //    원반[1]을 1기둥에서 3기둥으로 옮김
    //    원반[2]을 1기둥에서 2기둥으로 옮김
    //    원반[1]을 3기둥에서 2기둥으로 옮김
    //    원반[3]을 1기둥에서 3기둥으로 옮김
    //    원반[1]을 2기둥에서 1기둥으로 옮김
    //    원반[2]을 2기둥에서 3기둥으로 옮김
    //    원반[1]을 1기둥에서 3기둥으로 옮김
    @Test
    void 꼬리자르기() {

        int size = 4;
        final List<HanoiDisc> hanoiDiscs = moveList(size, 1, 3);
        final List<HanoiDisc> test = moveListNoTail(size, 1, 3);
        System.out.printf("높이 : %d, 정상값 : %d, 실제값 : %d \n",size, hanoiDiscs.size(), test.size() );

        System.out.println("==== 정상 ====");
        hanoiDiscs.forEach(System.out::println);

        System.out.println("=== 테스트 시작 ===");
        for (int i = 0; i < hanoiDiscs.size(); i++) {
            System.out.println(hanoiDiscs.get(i));


            Assertions.assertThat(test.get(i)).isEqualToComparingFieldByField(hanoiDiscs.get(i));
        }


    }


//    public static void moveList(List<HanoiDisc> list, int no, int from, int to) {
//        if (no > 1) {
//            moveList(list,no - 1, from, 6 - from - to);
//        }
//        list.add(new HanoiDisc(no, from, to));
//        if (no > 1) {
//            moveList(list,no - 1, 6 - from - to, to);
//        }
//    }

    //    원반[1]을 1기둥에서 3기둥으로 옮김
//    원반[2]을 1기둥에서 2기둥으로 옮김
//    원반[1]을 3기둥에서 2기둥으로 옮김
//    원반[3]을 1기둥에서 3기둥으로 옮김
//    원반[1]을 2기둥에서 1기둥으로 옮김
//    원반[2]을 2기둥에서 3기둥으로 옮김
//    원반[1]을 1기둥에서 3기둥으로 옮김
    public static void moveListNoTail(List<HanoiDisc> list, int no, int from, int to) {

        GenericDoubleStack<HanoiDisc> stack = new GenericDoubleStack<>(100);

        /*
        to->from 으로 이동.
        fn(from -> to) 는
            from -> mid
            from -> to
            mid -> to
        첫 번재는 고정이다. 왜냐하면 스택처럼 계속 쌓이기 때문이다. 그러므로 뒷 부분을 수정해야 한다. from 과 mid 가 계속 스위치 된다.


        */

        int count = 0;
        while (no > 0) {
            int mid = 6 - from - to;

            moveListNoTail(list, no - 1, from, mid); // 여기서 모두 스택에 쌓기 떄문에 from / to는 아래의 영향을 결코 받지 않는다. // 하지만 n -1 이후의 것은 영향을 받는다. 그러므로 from to 는 여기서는 변동이 없어야 한다.

            System.out.printf("!%d이 %d에서 %d로 간다\n", no, from, to);  // 스택에서 pop되어 1부터 쌓이기 시작한다.

            list.add(new HanoiDisc(no, from, to));

            no--;
            from = 2;

            if (count++ > 100) {
                break;
            }
        }

    }


}
