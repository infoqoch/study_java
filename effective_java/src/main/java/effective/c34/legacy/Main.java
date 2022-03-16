package effective.c34.legacy;

import org.junit.jupiter.api.Test;

/*
- 정수, 문자열 열거 패턴(int enum pattern)은 여러모로 문제가 많다.
- 값으로 관리하기 때문에 깨지기 쉽다. 정수로 표현할 경우 디버깅 과정에서 정확하게 무엇인지 판단하기 어렵다. 문자열로 할 경우, 문자열을 비교하는 자원이 낭비된다.
- 상수의 총 갯수의 관리 또한 어렵다.
- 하드코딩으로의 문제가 있다.
- 컴파일러 과정에서 문제를 확인하기 어렵다.

- 이와 달리 enum은 강력한 기능을 제공한다.
- 열거 타입 각각은 모두 클래스이다. 클래스로서 다양한 기능과 메서드 등을 추가할 수 있다.
- 싱글턴을 보장한다.
- enum의 갯수를 파악할 수 있다.(values())
- enum이 정상 동작하지 않으면 컴파일 에러가 발생한다.
*/
public class Main {

    @Test
    void test_legacy() {
        int error = LegacyEnumPattern.ERROR;
        String name = LegacyEnumPattern.HER_NAME;
    }

    @Test
    void test_enum() {
        for(Enum a : Enum.values()) {
            System.out.println(a.toString());
        }
    }
}
