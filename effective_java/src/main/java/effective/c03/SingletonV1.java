package effective.c03;

public class SingletonV1 {
	// static final 이므로 메모리에서의 유일함을 보장한다. 쓰레드로부터 안전하다.
	public static final SingletonV1 Instance = new SingletonV1();

	// 리플렉션의 경우 싱글톤임에도 불구하고 객체 생성 가능하다. 아래의 에러를 통해 원천적으로 싱글톤의 재생성을 막는다.
	private SingletonV1() {
		throw new AssertionError();
	}

}
