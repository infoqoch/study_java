package effective.c42;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
- 자바 8 이후로 추상 메서드 하나 짜리의 인터페이스를 활용한 람다식을 사용한다.
- 람다에서는 Comparator 를 명시하지 않았지만, 컴파일러가 문맥을 통하여 자동으로 추론한다. 타입을 반드시 명시해야하는 경우가 아니라면, 람다에는 매개변수 타입을 생략한다.
- 람다의 타입추론에 있어서 중요한 근거 중 하나는 제네릭이다. 그러므로 람다를 사용할 때 제네릭을 잘 활용한다.

- 람다를 사용할 때는 한 줄, 길면 세 줄까지만 허용한다. 그렇지 않으면 람다 특유의 표현력을 가지기 어렵다.
- 추상 클래스의 인스턴스는 람다로 만들 수 없다.
- 람다의 this는 바깥 인스턴스를 의미하여 익명 객체 this는 자기 자신을 가리킨다.
- 람다와 익명함수는 JVM 별 직렬화가 상이하므로, 절대로 직렬화 하지 않는다.
*/
public class LambdaTest {
	@Test
	void test_anno() {
		System.out.println("== 익명함수 ==");
		List<String> words = sampleWordList();
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		words.stream().forEach(System.out::println);
	}

	@Test
	void test_lambda() {
		System.out.println("== 람다 ==");
		List<String> words = sampleWordList();
		Collections.sort(words, (o1 , o2) -> Integer.compare(o1.length(), o2.length()));
		words.stream().forEach(System.out::println);
	}

	@Test
	void test_lambda2() {
		System.out.println("== 람다2 ==");
		List<String> words = sampleWordList();
		words.sort((o1,o2) -> Integer.compare(o1.length(), o2.length()));
		words.stream().forEach(System.out::println);
	}

	List<String> sampleWordList() {
		List<String> words = new ArrayList<>();
		words.add("kim");
		words.add("ramen");
		words.add("ox");
		words.add("kimchi");
		words.add("cider");
		return words;
	}
}
