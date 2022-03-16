package effective.c34.operation;

public enum Operation {
	PLUS, MINUS, TIMES, DIVIDE;

	public double apply(double x, double y) {
		switch(this) {
			case PLUS: return x+y;
			case MINUS: return x-y;
			case TIMES: return x*y;
			case DIVIDE: return x/y;
		}
		throw new AssertionError();
	}

	public static void main(String[] args) {
		Double result = Operation.TIMES.apply(4, 10);
		System.out.println("result : "+result);
	}
}
