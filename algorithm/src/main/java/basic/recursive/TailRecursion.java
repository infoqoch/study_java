package basic.recursive;

import basic.stack.IntDoubleStack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TailRecursion {


    @Test
    void 기본테스트(){
        recur(4);
    }

    @Test
    void 리스트형태(){
        // given
        final List<Integer> list  = recurList(4);
//        list.stream().forEach(System.out::println);

        final List<Integer> sample = Arrays.asList(new Integer[]{1, 2, 3, 1, 4, 1, 2});

        // when
        final List<Integer> result = recurList(4);

        // then
        Assertions.assertThat(result).isEqualTo(sample);
    }

    @Test
    void 꼬리제거(){
        // given
        int num = 4;

        for(; num<10; num++){
            final List<Integer> sample = recurList(num);

            // when
            final List<Integer> result = recurNoTailList(num);
            if(num == 4)
                result.stream().forEach(System.out::println);

            // then
            Assertions.assertThat(result).isEqualTo(sample);
        }

    }


    @Test
    void 재귀제거(){
        // given
        int num = 4;

        for(; num<10; num++){
            final List<Integer> sample = recurList(num);

            // when
            final List<Integer> result = recurNoRecur(num);
            if(num == 4)
                result.stream().forEach(System.out::println);

            // then
            Assertions.assertThat(result).isEqualTo(sample);
        }

    }

    public static List<Integer> recurNoRecur(int n) {
        final ArrayList<Integer> list = new ArrayList<>();
        recurNoRecur(list, n);
        return list;
    }

    /*
    * 솔직히 이 부분은 책을 보니까 이해가 갔다. 진짜 어려우면서 쉬웠다.
    * 핵심적인 부분은 반복문{add(n), n-2} 부분이다. 이 부분에 대해서 n의 값을 순차적으로 제공해야 한다.
    * n의 값은 제공된 숫자의 역순으로 제공된다. 5라면 5,4,3,2,1 이 제공된다.
    * 그리고 5는 fn(4), add(5), 반복문(n-2)로 동작한다. 이때 특징은 fn(4)는 fn(3), fn(2), fn(1) 을 먼저 호출한다.
    * 이 말은 fn(1) -> fn(2) -> fn(3) -> fn(4) 과 같고 그 이후에 본체 부분이 동작한다.
    * 그러니까 5,4,3,2,1 을 스택으로 쌓고, 1,2,3,4,5 를 순서대로 꼬리를 수행하면 된다.
    * 동작은 하는데 솔직히 이 부분은 음 아직 완전히 이해한 것은 아니다.
    * 외우면 이해 가는 것도 있다. 일단 최대한 외워보고 해보자.
    * 그런데 continue 와 break 를 여러 곳에 사용하는 아래의 반복문 형태도 흥미롭다. 음. 익숙해지자.
    */
    private static void recurNoRecur(ArrayList<Integer> list, int n) {
        IntDoubleStack stack = new IntDoubleStack(n);

        while(true){
            if(n>0){  // 꼬리 부분에 n-2 가 스택을 쌓을 수 있다. 그러므로 스택은 계속 활용된다.
                stack.pushLeft(n--); // 스택을 쌓고 그것을 다시 사용한다.
                continue;
            }
            if(!stack.isEmpty()){
                n = stack.popLeft();
                list.add(n);
                n = n - 2;
                continue;
            }
            break;
        }

//        원본
//        while(n > 0){
//            recurNoTail(list, n-1);
//            list.add(n);
//            n = n - 2;
//        }
    }


    /*
    꼬리제거, 하노이에 대하여 지금까지는 일종의 제귀함수 제거 패턴이 있는지 알았다. 그러나 그렇게 생각하면 안될 것 같다.
    상방식 분석을 하되, 그것이 어떤 영향을 미칠지에 대하여 진행해야 함. 상방식은 숫자가 적을 때의 패턴이 반복됨을 상정하는 방식이다. 보통 재귀 함수는 이런 식의 패턴을 가지는 것으로 보인다.
    정확하게는 모르지만 재귀함수를 활용할 경우 이를 자동으로 꼬리제거를 해주는 언어가 존재한다고 한다. 아마 자바도 그렇겠지? 그런데 이 경우 팩토리얼 같은 형태의 리턴 n*factorial(n) 은 안된다고 한다. 그냥 재귀 혼자만 리턴하거나 반복문을 돌려야 한다. 이러한 부분은 정확하게 몰라 다시 찾아봐야 할 것 같다.
    재귀가 성능 상 안좋은 경우가 많다고 한다. 그래서 언어 자체에서 꼬리제거를 지원하고 혹은 꼬리를 제거하는 방식으로 코드를 구현한다고 한다.
    모든 재귀함수는 결과적으로 반복문으로 변경 가능하다고 한다.
    솔직히 좀 많이 어려운데 여러 번 하면 익숙해지지 않을까 생각한다. 어차피 넘어야 할 산이다. 열심히 넘자. 화이팅.
    */
    
    /*
    * n이 0일 경우는 아예 동작하지 않는다. 그러니까 0을 출력할 일은 없다.
    * n이 1일 경우, 0, -1을 호출하므로 동작하지 않고 1을 인쇄한다. 1
    * n이 2일 경우, 2를 출력하고 1이 동작하여 1을 출력한다. "2", 1
    * n이 3일 경우, 2를 재귀함수로 돌린다음 3이 들어간다. recur(2), add(3), recur(1) -> 2,1,"3",1
    * n이 4일 경우, 3을 재귀함수로 돌린다음 4가 들어가고 2를 재귀함수로 돌린다. recur(3), add(4), recur(2) -> (recur(2), add(3), recur(1)), add(4), (recur(2)) -> 2,1,3,1,"4",2,1
    * n이 5일 경우, 4을 재귀함수로 돌린다음 5가 들어가고 3를 재귀함수로 돌린다.
    * 꼬리의 경우 결과적으로 해당 재귀함수를 숫자를 -2를 하여 돌리는 것과 다름 없다.
    * 이는 아래와 같다.
    * */
    public static List<Integer> recurNoTailList(int n) {
        final ArrayList<Integer> list = new ArrayList<>();
        recurNoTail(list, n);
        return list;
    }

    private static void recurNoTail(ArrayList<Integer> list, int n) {
        while(n > 0){
            recurNoTail(list, n-1);
            list.add(n);
            n = n - 2;
        }
    }

    public static List<Integer> recurList(int n) {
        final ArrayList<Integer> list = new ArrayList<>();
        recurList(list, n);
        return list;
    }

    private static void recurList(ArrayList<Integer> list, int n) {
        if(n > 0){
            recurList(list, n-1);
            list.add(n);
            recurList(list, n-2);
        }
    }

    public static void recur(int n){
        if(n > 0){
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }
}
