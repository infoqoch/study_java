package types;

import org.junit.jupiter.api.Test;

/*
*
* 정확하게는 스코프 문제가 아니라 메모리와 참조변수의 문제이다.
* collection 과 object 는 참조변수와 관계 없이 힙에 있다. 그러므로 참조변수가 어디에 있든 접근 가능하다.
* 하지만 primitive type 은 스택에 쌓이고, 쌓인 스택은 작업 중인 스택 메모리가 결코 참조할 수 없다. 그러므로 어떤 매서드에 어떤 인자가 들어갔다 하더라도, 그 인자는 그것의 원래 값과 전혀 관계가 없어진다.
*
*/
public class PrimitiveScopeTest {

    @Test
    void 기본타입의스코프(){
        int localInt1 = 0;  // ................(1)
        int localInt2;   // ................(2)
        String localStr1 = "java";

        if(localInt1==0){
            localInt1 = 1;
            localInt2 = 2;
            int localInt3 = 3;// ...........(3)
        }

        if(!localStr1.equals("hello")){
            System.out.println(localInt1);  // 1
//            System.out.println(localInt2);  // 컴파일에러
//            System.out.println(localInt3);  // 컴파일에러
        }

    }
}
