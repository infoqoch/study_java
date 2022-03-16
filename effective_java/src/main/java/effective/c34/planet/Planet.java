package effective.c34.planet;

public enum Planet {
	MERCURY(100000, 324),
	VENUS(2342, 334),
	EARTH(12343, 2342),
	MARS(345, 2342),
	JUPITER(34543, 234432),
	SATURN(3434, 343),

	// 상수 하나를 제거하더라도 전혀 문제가 없다.
	// 클라이언트에서 참조한다면 컴파일 에러를 발생한다.
	// URANUS(12343, 34),

	NEPTUNE(3245435, 2342);

	// 필드는 기본적으로 final 이다.
	private final double mass;
	private final double radius;
	private final double surfaceGravity;

	private static final double G = 6.213123213;

	// 생성자로 객체를 생성하여 사용한다.
	Planet(double mass, double radius){
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G*mass/(radius*radius); // 성능 최적화를 위하여 생성자 때 계산을 한다.
	}

	// 필드를 public으로 공개하지 않고, 메서드를 통해 값을 리턴한다.
	// 열거타입은 getMass 가 아닌 mass() 형태로 getter를 연다.
	public double mass() {
		return mass;
	}

	public double radius() {
		return radius;
	}

	public double surfaceGravity() {
		return surfaceGravity;
	}

}
