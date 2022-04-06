package effective.c57;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class C59 {
	ThreadLocalRandom random = ThreadLocalRandom.current();
	@Test
	void test() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0; i<30; i++) {
			int ran = random.nextInt(1000);
			if(min > ran)
				min = ran;
			if(max < ran)
				max = ran;
		}
		System.out.println("min : "+ min);
		System.out.println("max : "+ max);
	}

}
