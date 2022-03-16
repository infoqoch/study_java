package effective.c34.payroll;

import org.junit.jupiter.api.Test;

public class PayrollDay2Test {
	@Test
	void test() {
		String str = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";

		for(String s : str.split(" ")) {
			System.out.print(s.toUpperCase()+",");
		}

	}

}
