package effective.c42;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
	PLUS((d1,d2)->d1+d2)
	, MINUS((d1,d2)->d1-d2);

	// 함수형 인터페이스를 필드로 가진다.
	private final DoubleBinaryOperator op;

	private Operation(DoubleBinaryOperator op) {
		this.op = op;
	}

	double apply(double d1, double d2) {
		return op.applyAsDouble(d1, d2);
	}

	public static void main(String[] args) {
		System.out.println("Operation.PLUS.apply(1, 2) = " + Operation.PLUS.apply(1, 2));
		System.out.println("Operation.MINUS.apply(1, 2) = "+ Operation.MINUS.apply(1, 2));
	}
}
