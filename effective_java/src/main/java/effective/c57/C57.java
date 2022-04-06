package effective.c57;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class C57 {
	@Test
	void test1() {
		List<String> list = sampleList();

		// 권장하는 방식
		for(String s : list) {
			System.out.println(s);
		}

		System.out.println("===");

		// iterator를 사용할 경우 권장하는 방식
		// i.next()로 지녁변수를 초기화한다. 이를 최대한 우회하여 향상된 for문을 사용하는 것이 낫다.
		for(Iterator<String> i = list.iterator(); i.hasNext();) {
			String s = i.next();
			System.out.println(s);
		}

		for(int i = 0, n = expensiveComputation(); i < n; i++) {
			System.out.println("하이" + i);
		}

		for(int i = 0, n = expensiveComputation(); i < n; i++) {
			System.out.println("하이" + i);
		}
	}

	int expensiveComputation() {
		return 10;
	}

	private List<String> sampleList() {
		List<String> list = new ArrayList<>();
		for(int i=0; i<10; i++)
			list.add(UUID.randomUUID().toString().substring(0,8));
		return list;
	}
}
