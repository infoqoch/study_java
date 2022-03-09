package effective.c28;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
- 배열의 경우 Sub[] 이 Super[] 의 하위타입이 된다. 그러니까 Object[] 가 String[] 의 하위타입이 된다.
- 이러한 배열의 특성 때문에 문법 상 맞지 않는 코드가 컴파일 과정에서 승인된다.
- 리스트는 제너릭의 데이타타입간 관련이 있다 하더라도 타입 변경이나 상위/하위타입으로 적용되지 않는다. 그래서 배열이 가지는 문제로부터 자유롭다.

- 제너릭의 경우 기존의 문법 List list = new ArrayList(); 에 맞추기 위하여 컴파일 시점에서만 제너릭 관련한 데이터가 있고 실제 런타임에는 제너릭 관련한 값이 존재하지 않는다.
- 이렇게 런타임에서 데이터가 제거되는 것을 소거(erasure)라 한다. 그리고 이러한 제너릭을 실체화 불가 타입이라 한다.
- 이러한 방식으로 인하여 제너릭이 존재하지 않았던 레거시 코드와의 호환성을 가지게 되었다. 또한 덕분에 컴파일 시점에서 제너릭과 관련한 에러를 잡아낼 수 있게 되었다.
- 한편, 배열은 런타임에서도 데이터타입에 대한 정보를 가지고 있다. Integer[]는 런타임에서도 Integer 데이터 타입을 가지고 있다. 이러한 패러다임의 차이로 제너릭 배열이 허용되지 않는다.

- 제너릭은 실체화불가타입이지만, 와일드카드 List<?>는 실체화가 가능하다.

-

*/
public class GenericArrayTest {
	@Test
	void test() {
		Object[] objets = new Integer[10];
		objets[0] = 1;
		// String 을 삽입	할 수 있다.
		Assertions.assertThatThrownBy(()->{
			objets[1] = "hello!";
		}).isInstanceOf(ArrayStoreException.class);
	}

	@Test
	void test2() {
		// 컴파일 에러 발생
		// List<Object> objects = new ArrayList<Integer>();

		List<Integer> objects = new ArrayList<Integer>();
		objects.add(123);

		// 컴파일 에러 발생
		// objects.add("kim");
	}
}
