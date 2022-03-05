package effective.c23;

import org.junit.jupiter.api.Test;

public class Main {
	@Test
	void test1() {
		FigureV1 rec1 =  new FigureV1(10.0, 10.0);
		System.out.println("result : "+ rec1.area());

		FigureV1 cir1 =  new FigureV1(10.0);
		System.out.println("result : "+ cir1.area());
	}


	@Test

	void test2() {
		Square sqr = new Square(10.0);
		System.out.println("sqr : "+ sqr.area());
	}
}
