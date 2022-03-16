package effective.c34.operation;

public enum Operation2 {
	PLUS{
		public double apply(double x, double y) {return x+y;}
	}, MINUS{
		public double apply(double x, double y) {return x-y;}
	}, TIMES{
		public double apply(double x, double y) {return x*y;}
	}, DIVIDE{
		public double apply(double x, double y) {return x/y;}
	};

	// switch의 분기는 깨지기 쉬운 메서드이다. 상수의 추가에 따라 변동이 심하다.
	// 각 객체마다의 매서드를 정의하여 더 좋은 코드를 구현한다.
	// abstract 을 통해 코드 구현을 강제한다.
	public abstract double apply(double x, double y);


	public static void main(String[] args) {
		Double result = Operation2.TIMES.apply(4, 10);
		System.out.println("result : "+result);
	}

}
