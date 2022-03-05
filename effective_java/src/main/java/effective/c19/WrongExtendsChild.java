package effective.c19;

/*
 * 생성자 구현시 순서
 * 1번 오버라이드
 * 2번 super()
 * 3번 필드값 삽입
 *
 */
public class WrongExtendsChild  extends WrongExtends {
	private final String name;

	public WrongExtendsChild() {
		name = "kim";
	}

	@Override
	public void initConstruct() {
		System.out.println(name);
	}

	public static void main(String[] args) {
		WrongExtendsChild child = new WrongExtendsChild(); // override를 하지만 필드는 super 이후에 동작한다. 그러므로 name 필드는 null 이 반환된다.
		child.initConstruct();
	}
}
