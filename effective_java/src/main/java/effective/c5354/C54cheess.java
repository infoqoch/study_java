package effective.c5354;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C54cheess {

	// 특정 API를 구현했고, 불변객체로서 아래의 객체를 방어적 복사를 통하여 전달한다고 가정한다.
	// 특정 상황에서는 컬렉션에 어떤 값도 없을 수 있다. 이런 경우 어떤 식으로 전달하는 것이 가장 좋을까?
	private List<LocalDate> target = new ArrayList<>();

	List<LocalDate> getAttendanceNullable(){
		return target.isEmpty() ?
				null : // null을 반환환다.
				new ArrayList<>(target); // 방어적 복사를 한다.
	}

	@Test
	void test_null() {
		final List<LocalDate> attendance = getAttendanceNullable();
		if(attendance !=null&& attendance.contains(LocalDate.now()))
			System.out.println("오늘 출석했구나. 아주 성실하구나?");
	}

	List<LocalDate> getAttendanceV1() {
		return new ArrayList<>(target); // 초기화는 큰 성능을 요구하지 않는다.
	}

	@Test
	void test_empty(){
		final List<LocalDate> attendance = getAttendanceV1();
		if(attendance.contains(LocalDate.now()))
			System.out.println("오늘 출석했구나. 아주 성실하구나?");
	}


	List<LocalDate> getAttendanceV2() {
		return target.isEmpty()
				? Collections.emptyList() // 특수한 경우 최적화를 위해 사용한다. 초기화하지 않아 성능에 도움이 된다.
				: new ArrayList<>(target);
	}

	@Test
	void test_return_exist_empty(){
		final List<LocalDate> attendance = getAttendanceV2();
		if(attendance !=null&& attendance.contains(LocalDate.now()))
			System.out.println("오늘 출석했구나. 아주 성실하구나?");
	}


}
