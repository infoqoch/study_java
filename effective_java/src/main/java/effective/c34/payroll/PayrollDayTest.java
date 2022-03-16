package effective.c34.payroll;

import org.junit.jupiter.api.Test;

public class PayrollDayTest {
	// @Test
	void test() {
		String str = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";

		for(String s : str.split(" ")) {
			System.out.print(s.toUpperCase()+",");
		}
	}

	@Test
	void test_v1() {
		System.out.println("PayrollDay.FRIDAY.pay(60*7, 10) = "+PayrollDay.FRIDAY.pay(60*10, 10));
		System.out.println("PayrollDay.SUNDAY.pay(60*7, 10) = "+PayrollDay.SUNDAY.pay(60*10, 10));
	}

	@Test
	void test_v2() {
		System.out.println("PayrollDay.FRIDAY.pay(60*7, 10) = "+ PayrollDay2.FRIDAY.pay(60*10, 10));
		System.out.println("PayrollDay.SUNDAY.pay(60*7, 10) = "+PayrollDay2.SUNDAY.pay(60*10, 10));
	}
}
