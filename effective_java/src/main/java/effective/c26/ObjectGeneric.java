package effective.c26;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
- List 와 List<Object>의 차이?
- 전자는 제너릭을 아예 사용하지 않고, 후자는 모든 타입을 허용한다는 의미이다.
- 컴파일 시점에서 잡아내기 때문에 안정하게 사용 가능하다.

- 타입을 비교할 때는 와일드카드를 사용한다.
- 와일드카드는 순수한 비교를 위해 사용하며, 어떤 원소도 넣을 수 없다. 원소를 넣으려 하면 컴파일 에러가 발생한다. 불변식을 보장한다.
- 더 나아가 타입에 대한 고민이 필요없기 때문에 매우 유연한 작성이 가능하다.

- 결론적으로 모든 데이터 타입을 삽입하고 싶으면 Object를 사용하며
- 데이터 비교를 할 때는 와일드카드를 사용한다. 이 경우 해당 객체들의 불변을 보장한다.

*/
public class ObjectGeneric {

	@Test
	void raw타입을_매개변수로() {
		List<String> list = new ArrayList<>();
		unsafeAdd(list, "hi");
		unsafeAdd(list, 123);

		// 런타임 시점에서 에러가 발생한다.
		Assertions.assertThatThrownBy(()->{
			list.forEach(obj -> {
				String converted = (String) obj;
			});
		}).isInstanceOf(ClassCastException.class);
	}

	void unsafeAdd(List list, Object o) {
		list.add(o);
	}


	@Test
	void generic_object를_매개변수로() {
		List<String> list = new ArrayList<>();
//		safeAdd(list, "hi");
//		safeAdd(list, 123);

		// 런타임 시점에서 에러가 발생한다.
		Assertions.assertThatThrownBy(()->{
			list.forEach(obj -> {
				String converted = (String) obj;
				System.out.println("converted value : "+converted);
			});
		}).isInstanceOf(ClassCastException.class);
	}

	void safeAdd(List<Object> list, Object o) {
		list.add(o);
	}

	/*


	 */

	@Test
	void testSet() {
		Set<String> s1 = new HashSet<>();
		s1.add("lee");
		s1.add("choi");

		Set<String> s2 = new HashSet<>();
		s2.add("lee");
		s2.add("kim");

		int result = numElementsInCommon(s1, s2);
		System.out.println("result : " + result);

	}

	int numElementsInCommon(Set s1, Set s2) {
		int result = 0;
		for(Object o1 : s1) {
			if(s2.contains(o1))
				result++;
		}
		s1.add("park");
		return result;
	}

	@Test
	void testWildCard() {
		Set<String> s1 = new HashSet<>();
		s1.add("lee");
		s1.add("choi");

		Set<String> s2 = new HashSet<>();
		s2.add("lee");
		s2.add("kim");

		int result = numElementsInCommonWild(s1, s2);
		System.out.println("result : " + result);

	}

	int numElementsInCommonWild(Set<?> s1, Set<?> s2) {
		int result = 0;
		for(Object o1 : s1) {
			if(s2.contains(o1))
				result++;
		}
		// 컴파일 에러가 발생한다.
		// s1.add("park");
		return result;
	}

}
