package effective.c03;

public class SingletonV2Factory {
	private static final SingletonV2Factory INSTANCE = new SingletonV2Factory();

	// 팩토리 형태로 인스턴스를 전달한다.
	// 이전의 방식보다 유연하다. supplier 등 사용 가능하다. 여러 방식으로 조작 가능하다.
	public SingletonV2Factory getInstance() {
		return INSTANCE;
	}

}
