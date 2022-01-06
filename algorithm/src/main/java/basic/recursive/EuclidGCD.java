package basic.recursive;

import org.junit.jupiter.api.Test;

public class EuclidGCD {
    @Test
    void 유클리드_최대공약수(){
        // 최대공약수를 구하는 것은 가장 큰 정사각형을 구하는 것과 같다.
        // 숫자 두 개를 사각형의 높이와 너비로 본다.
        // 높이와 너비 중 작은 값을 기준으로 정사각형을 만들고
        //      -> 정사각형을 다 만들어서 없어지면 그 값이 공약수이며
        //      -> 정사각형이 아닌 직사각형이 남았으면 그 값 중 작은 값을 기준으로 다시 정사각형을 만든다.
        //          -> 계속 정사각형을 나눌 필요가 없고 긴 값과 작은 값의 나머지를 보면 된다.

        int width = 8;
        int height = 22;

        int result = euclidGCD(width, height);
        System.out.println(result);
    }

    private int euclidGCD(int x, int y) {
        System.out.printf("%d, %d\n", x, y);
        if(y==0)
            return x;
        return euclidGCD(y, x%y);
    }

}
