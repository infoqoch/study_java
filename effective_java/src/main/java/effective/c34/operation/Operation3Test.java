package effective.c34.operation;

import org.junit.jupiter.api.Test;

public class Operation3Test {
	@Test
	void test1() {
		double x = 10;
		double y = 20;
		for(Operation3 o : Operation3.values()) {
			System.out.printf("%s %s %s = %s \n", x, o.symbol(), y, o.apply(x, y) );
		}
	}

	@Test
    void test2() {
		// valueOf로 객체를 꺼낼 수 있지만
		System.out.println("Operation3.valueOf(\"MINUS\"); = "+Operation3.valueOf("MINUS"));

		// fromString이란 메서드로 구현할 수 있다.
    	System.out.println("Operation3.fromString(\"-\") = "+ Operation3.fromString("-"));
    	System.out.println("Operation3.fromString(\"+\") = "+ Operation3.fromString("+"));
    	System.out.println("Operation3.fromString(\"&\") = "+ Operation3.fromString("&"));
    }
}
