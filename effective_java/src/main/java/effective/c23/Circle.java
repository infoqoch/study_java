package effective.c23;

public class Circle extends Figure{
	private final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI*(radius*radius);
	}

}
