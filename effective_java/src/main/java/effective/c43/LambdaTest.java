package effective.c43;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LambdaTest {
	@Test
	void what_is_map_merge() {
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "kim");
		map1.put(2, "lee");

		Map<Integer, String> map2 = new HashMap<>();
		map2.put(1, "kimmm");
		map2.put(3, "lee");

		// 중복된 키가 있을 경우 합치기 곤란하니까 값을 조작할 수 있다.
		// map1.forEach((k, v) -> map2.merge(k, v, (oldValue, value) -> oldValue + " - " +value));
		map1.forEach((k, v) -> map2.merge(k, v, String::concat));

		System.out.println("map1");
		map1.keySet().stream().forEach(key -> System.out.printf("key : %d value : %s\n",key, map1.get(key)));

		System.out.println("map2");
		map2.keySet().stream().forEach(key -> System.out.printf("key : %d value : %s\n",key, map2.get(key)));
	}

	@Test
	void merge_integer() {
		Map<Integer, Integer> map1 = new HashMap<>();
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		Map<Integer, Integer> map2 = new HashMap<>();
		map2.put(1, 3);
		map2.put(2, 6);

		map1.forEach((k, v) -> map2.merge(k, v, Integer::sum));

		System.out.println("map1");
		map1.keySet().stream().forEach(key -> System.out.printf("key : %d value : %s\n",key, map1.get(key)));

		System.out.println("map2");
		map2.keySet().stream().forEach(key -> System.out.printf("key : %d value : %s\n",key, map2.get(key)));
	}
}
