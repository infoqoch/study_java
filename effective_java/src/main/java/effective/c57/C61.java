package effective.c57;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class C61 {
	@Test
	void equals() {
		Comparator<Integer> compare = (i, j) -> (i > j) ? -1 : (i == j ? 0 : 1);

		System.out.println("compare.compare(1, 2) = " + compare.compare(1, 2));
		System.out.println("compare.compare(1, 1) = "+compare.compare(1, 1));
		System.out.println("compare.compare(2, 1) = "+compare.compare(2, 1));


		System.out.println("===========");
		System.out.println("compare.compare(1, 2) = " + compare.compare(new Integer(1), new Integer(2)));
		System.out.println("compare.compare(1, 1) = "+compare.compare(new Integer(1), new Integer(1))); // 객체간 비교(==)를 할 경우 다르다고 나온다.
		System.out.println("compare.compare(2, 1) = "+compare.compare(new Integer(2), new Integer(1)));

		Comparator<Integer> compare2 = (ii, jj) -> {
			int i = ii;
			int j = jj;
			return (i > j) ? -1 : (i == j ? 0 : 1);
		};

		System.out.println("compare2.compare(1, 2) = " + compare2.compare(new Integer(1), new Integer(2)));
		System.out.println("compare2.compare(1, 1) = "+compare2.compare(new Integer(1), new Integer(1))); // int로 언박싱을 한 후 정상동작함을 확인할 수 있다.
		System.out.println("compare2.compare(2, 1) = "+compare2.compare(new Integer(2), new Integer(1)));
	}


	Integer i;

	@Test
	void nullPoint() {
		if(i>100)
			System.out.println(i+"는 100보다 크다");
	}

	@Test
	void slowSum() {
		Long boxedLong = 0l;
		long primitiveLong = 0l;


		long start1 = System.currentTimeMillis();
		for(int i=0; i<Integer.MAX_VALUE; i++) {
			boxedLong += i;
		}
		System.out.println("첫 번째 시간 : "+(start1-System.currentTimeMillis()));

		long start2 = System.currentTimeMillis();
		for(int i=0; i<Integer.MAX_VALUE; i++) {
			primitiveLong += i;
		}
		System.out.println("두 번째 시간 : "+(start2-System.currentTimeMillis()));
	}
}
