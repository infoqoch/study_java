package effective.c23;

public class FigureV1 {
	enum Shape {RECTANGLE, CIRCLE}

	// 현재 모양
	final Shape shape;

	// 사각형에서 사용
	double length;
	double width;

	// 원에서 사용
	double radius;

	// 원에 사용
	FigureV1(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	// 사각형에 사용
	public FigureV1(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	// 스위치로 분기
	double area() {
		switch(shape) {
			case RECTANGLE:
				return length*width;
			case CIRCLE:
				return Math.PI*(radius*radius);
			default:
				throw new AssertionError(shape);
		}
	}
}
