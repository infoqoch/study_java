package effective.c5354;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class C53 {
	@Test
	void test_runtime() {
		// v1
		Assertions.assertThat(min(10,1,2,3,4,5)).isEqualTo(1);
		// Assertions.assertThat(min()).isEqualTo(0); // expected: 0 but was: 2147483647

		// v2
		Assertions.assertThat(minV2(10,1,2,3,4,5)).isEqualTo(1);
		Assertions.assertThatThrownBy(()->minV2())
			.isInstanceOf(IllegalArgumentException.class);// 런타임 에러 발생
//			.message().isEqualTo("0개 이상 입력하세요.");  // 런타임 에러 발생
	}

	int min(int... arg) {
		int min = Integer.MAX_VALUE;
		for(int i : arg) {
			if(i<min)
				min = i;
		}
		return min;
	}

	int minV2(int... arg) {
		if(arg.length==0)
			throw new IllegalArgumentException("0개 이상 입력하세요.");

		int min = Integer.MAX_VALUE;
		for(int i : arg) {
			if(i<min)
				min = i;
		}
		return min;
	}


	@Test
	void test_compile() {
		// v3
		Assertions.assertThat(minV3(10,1,2,3,4,5)).isEqualTo(1);
		// minV3(); // 컴파일 에러 발생
	}

	int minV3(int firstint, int... arg) {
		int min = firstint;
		for(int i : arg) {
			if(i<min)
				min = i;
		}
		return min;
	}

}
