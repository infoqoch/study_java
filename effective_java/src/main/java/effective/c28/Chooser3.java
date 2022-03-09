package effective.c28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
- 배열이 아닌 리스트로 한다.
- 형변환 문제가 사라지고 컴파일 시점에서 문제가 해결된다.
- 리스트를 가지고 굳이 배열을 사용할 이유가 없다.

- (Integer) list; 라는 형태의 캐스팅 자체가 사라진다는 의미를 알게 되었다.
- 이미 Integer로 타입이 확정되어 있고, 컴파일에서 확인하기 때문에, 이를 굳이 실체화 할 필요도 없고 캐스팅할 필요도 없다. 어떤 의미에서는 코드가 명확해지고 깔끔해진다.
- 하지만 (Integer) obj; 의 형태를 가지는 순간 형변환에 대한 우려를 가져야 하며, 코드 역시도 분명하지 않게 되어버린다. 왜냐하면 Object가 무엇인지를 확인해야 하기 때문이다. 이런 측면으로 보면 제너릭은 많은 장점이 있다.

*/
public class Chooser3<T> {
	private final List<T> choiceArray;

	public Chooser3(Collection<T> choices) {
		choiceArray = new ArrayList<>(choices);
	}

	public Object choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceArray.get(rnd.nextInt(choiceArray.size()));
	}

}
