package effective.c34.operation;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation3 {
	PLUS("+"){
		public double apply(double x, double y) {return x+y;}
	}, MINUS("-"){
		public double apply(double x, double y) {return x-y;}
	}, TIMES("*"){
		public double apply(double x, double y) {return x*y;}
	}, DIVIDE("/"){
		public double apply(double x, double y) {return x/y;}
	};

	private final String symbol;

	Operation3(String symbol){
		this.symbol = symbol;
	}

	public String symbol() {
		return symbol;
	}

	public abstract double apply(double x, double y);


	// 아래의 정적타입필드는 열거타입 상수 생성 후이다. 그러므로 아래의 코드는 의도한대로 정상 동작한다.
    private static final Map<String, Operation3> stringToEnum =
    		Stream.of(values()).collect(Collectors.toMap(e -> e.symbol(), e -> e));

    public static Optional<Operation3> fromString(String symbol){
    	return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
