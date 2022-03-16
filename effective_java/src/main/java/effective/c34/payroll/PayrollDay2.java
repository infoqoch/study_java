package effective.c34.payroll;

import static effective.c34.payroll.PayrollDay2.PayType.WEEKDAY;
import static effective.c34.payroll.PayrollDay2.PayType.WEEKEND;

/*
- 열거타입은 특별한 이유가 없으면 열거타입 항상 사용한다. 정확하게는 필요한 원소를 컴파일타임에 다 알 수 있는 상수 집합이라면 항상 열거 타입을 사용한다.
- 초기화로 인한 성능 손해는 사실상 거의 없으며, 런타임 시점에서 정수상수타입과 비교하더라도 차이가 거의 없다.
*/
public enum PayrollDay2 {
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY
	,SATURDAY(WEEKEND),SUNDAY(WEEKEND);

	private final PayType payType;

	// 전략 열거 타입 패턴
	// 열거 타입의 열거 타입을 정의하고, 해당 열거 타입에 대한 매서드를 구현한다.
	enum PayType{

		// switch를 사용하지 않아 안전하고 유연하다.
		WEEKDAY {
			int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked <= MINS_PER_SHIFT ? 0 :
                    (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
			}
		}, WEEKEND{
			int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked * payRate / 2;
			}
		};

		private static final int MINS_PER_SHIFT = 8*60;


		int pay(int minutesWorked, int payRate) {
			int basePay = minutesWorked * payRate;
			return basePay + overtimePay(minutesWorked, payRate);
		}

		// 차이를 가지는 오버타임에 대해서만 구현 객체로 만든다.
		abstract int overtimePay(int minutesWorked, int payRate);
	}

	PayrollDay2(){
		this.payType = WEEKDAY;

	}

	PayrollDay2(PayType payType){
		this.payType = payType;
	}

	int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

}

