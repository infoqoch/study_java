package effective.c28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
- 아래와 같은 경우 Object를 특정 타입으로 계속 변경해야 하는 문제가 발생한다.

*/
public class Chooser1 {
	private final Object[] choiceArray;

	public Chooser1(Collection choices) {
		choiceArray = choices.toArray();
	}

	public Object choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceArray[rnd.nextInt(choiceArray.length)];
	}
}
