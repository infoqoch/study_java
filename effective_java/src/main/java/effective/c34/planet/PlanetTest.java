package effective.c34.planet;

import org.junit.jupiter.api.Test;

public class PlanetTest {
	@Test
	void test() {
		System.out.println("Planet.EARTH.mass() = "+ Planet.EARTH.mass());

		for(Planet p : Planet.values()) {
			System.out.println(p+" : "+p.surfaceGravity());
		}
	}

}
