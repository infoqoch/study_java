package effective.c26;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*

- 클래스와 인터페이스를 선언할 때 타입 매개변수가 쓰이면, 이를 제네릭 클래스 혹은 제네릭 인터페이스라 한다. 이를 통틀어서 제네릭 타입이라 한다.
- 제네릭 타입은 매개변수화 타입(parameterized type)을 정의한다.
- 제네릭 타입은 제네릭이 없었던 이전의 코드를 위하여 타입 없이 선언될 수 있다. 하지만 이 경우 타입 컨버터의 문제가 발생할 수 있다. 신규로 개발하는 모든 것에 대해서는 반드시 매개변수에 정확한 타입을 입력해야 한다.
- 추가적으로 만약 타입을 명시하면 자바에서 자동으로 타입컨버터를 제공해준다. 이러한 편의 기능도 사용할 수 없다.
- @SuppressWarnings을 사용하면 컴파일 시점에서 제너릭과 관련한 에러를 누락한다. 하지만 ClassCastException은 런타임 오류이므로 찾기 어렵다.
	- 해당 어너테이션이 붙으면 더 어려워진다. 그러므로 해당 어너테이션을 가능하면 사용하지 않고 모든 제너릭 관련한 문제를 해소한다.
	- 만약 너무도 확실하게 타입 캐스팅 관련한 문제가 없을 경우 사용하고 주석을 담는다.
- 컴파일 시점에서 에러를 잡고, 타입 컨버터를 지원하는 등 제너릭의 장점은 매우 많다. 제너릭의 안정성과 표현력을 위하여 반드시 raw 타입을 사용하지 않는다!!
 * */
public class RawGeneric {
	@Test
	@SuppressWarnings("unchecked") // 확실하게 문제가 없을 경우만 사용해야 한다.
	void raw_generic_typeconvert_exception() {
		// given
		List list = new ArrayList<>();

		// when
		list.add("hello");
		list.add(1234);
		list.forEach(obj -> System.out.printf("obj value : %s obj class : %s\n", obj, obj.getClass()));

		// then
		Assertions.assertThatThrownBy(()->{
			list.forEach(obj -> {

				String converted = (String) obj;
				System.out.println("converted value : "+converted);
			});
		}).isInstanceOf(ClassCastException.class);
	}

	@Test
	void compile_error() {
		// given
		List<String> list = new ArrayList<>();

		// when
		list.add("kim");

		// given
		// list.add(1234);
		// java.lang.Error: Unresolved compilation problem:
		// The method add(int, String) in the type List<String> is not applicable for the arguments (int)
	}

	@Test
	void object_generic() {
		List<Object> list = new ArrayList<>();
	}
}
