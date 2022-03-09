package effective.c28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
- 이전의 방식보다는 좋지만 여전이 캐스팅 문제가 남아있다. 형변환 과정이 내부적으로 일어 난다.
- 제너릭과 관련한 데이터는 모두 사라진다. 타입과 관련한 형변환 예외가 발생할 수 있다.
*/
public class Chooser2<T> {
	private final T[] choiceArray;

	public Chooser2(Collection<T> choices) {
		choiceArray = (T[]) choices.toArray();
	}

	public Object choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceArray[rnd.nextInt(choiceArray.length)];
	}
}
