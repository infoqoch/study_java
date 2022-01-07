package basic.recursive;

import org.junit.jupiter.api.Test;

public class Hanoi {
    static void move(int no, int from, int to){
        if(no>1){
            move(no-1, from, 6-from-to);
        }
        System.out.printf("원반[%d]을 %s기둥에서 %s기둥으로 옮김\n", no, from, to);
        if(no>1){
            move(no-1, 6-from-to, to);
        }
    }

    @Test
    void 테스트(){
        move(3,1,3);
    }

}
