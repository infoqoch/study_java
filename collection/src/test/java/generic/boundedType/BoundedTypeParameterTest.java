package generic.boundedType;

import org.junit.jupiter.api.Test;

class BoundedTypeParameterTest {

    @Test
    void 제한된타입파라미터(){
        System.out.println(BoundedTypeParameter.compare(1, 2));
        System.out.println(BoundedTypeParameter.compare(2, 2));
        System.out.println(BoundedTypeParameter.compare(3, 2));
    }

    @Test
    void 제한된타입파라미터_예외(){
//        BoundedTypeParameter.compare(1, "2"); // 컴파일 에러가 발생
    }


}