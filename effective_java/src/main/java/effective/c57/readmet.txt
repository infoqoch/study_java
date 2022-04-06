# 일반적인 프로그래밍 원칙

## 57 지역변수의 범위를 최소화하라
- 지역변수에 대한 이해와 오남용을 방지하기 위하여, 지역변수의 사용은 최소화 한다.
- 만약 사용한다면 선언을 먼저하지 않고 최대한 초기화 때 선언한다.
- 지역변수를 최소화 할 수 있는 방법을 활용한다. 루프에서는 while -> for -> for-each 순으로 선호한다.

## 58 전통적인 for 문보다는 for-each 문을 사용하라

```java
List<String> list = sampleList();

// while 보다는 for문이 낫다.
// for문을 사용할 경우 향상된 for문을 사용한다.
for(String s : list) {
	System.out.println(s); // 반복문 블록 안에 변수가 단 하나 s 밖에 없다.
}

// iterator를 사용할 경우 권장하는 방식
// i.next()로 지녁변수를 초기화한다. 이를 최대한 우회하여 향상된 for문을 사용할 수 있도록 강구한다.
for(Iterator<String> i = list.iterator(); i.hasNext();) {
	String s = i.next();
	System.out.println(s);
}

for(int i = 0, n = expensiveComputation(); i < n; i++) {
	System.out.println("하이" + i);
}
```

## 59 라이브러리를 익히고 사용하라
- 현재 Random보다는 ThreadLocalRandom를 주로 사용한다. 그 이유는 라이브러리 자체의 결함, 성능, 편의기능, 동시성 문제 등 다양한 이유에 의해서이다.
- 표준 라이브러리를 사용하는 것의 장점은 매우 많다.
- 코드를 작성한 전문가의 지식과 경험이 녹아든 기능을 매우 편리하게 사용할 수 있다.
- 부수적인 업무는 라이브러리로 대체하고, 중요한 업무에 더 집중할 수 있다.
- 버전이 올라갈 수록 성능과 기능이 자동으로 추가된다.
- 대부분의 자바 개발자가 공유하는 지식이기때문에 유지보수에 좋다.

- 자바 개발자라면 적어도 java.lang, java.util, java.io + java.util.concurrent 에는 익숙해지자.

## 60 정확한 답이 필요하다면 float와 double은 피하라
- 부동소수점 문제로 인하여, 금융 등 엄격한 숫자 계산이 필요할 경우, BigDecimal 을 사용해야 한다.

## 61 박싱된 기본타입보다는 기본타입을 사용하라
- 박싱된 기본타입과 기본타입은 분리해서 사용해야 한다. 그렇지 않으면 코드의 문제가 발생하거나 성능 상 문제가 발생한다.
- 특별하게 박싱된기본타입이 필요하지 않는 한, 기본타입을 사용한다.

### 박싱된 기본타입을 비교할 경우
- Comparator를 구현하는데, 숫자 두 개가 동일할 때를 == 으로 비교한다.
- Integer의 경우 각각 다른 메모리를 차지하는 객체로 생성하였기 때문에, ==이 false가 되어, 영엉 0을 리턴하지 못한다.
- 이 경우 박싱된 타입을 꺼내야 한다.

```java
Comparator<Integer> compare = (i, j) -> (i > j) ? -1 : (i == j ? 0 : 1);

System.out.println("compare.compare(1, 2) = " + compare.compare(1, 2));
System.out.println("compare.compare(1, 1) = "+compare.compare(1, 1));
System.out.println("compare.compare(2, 1) = "+compare.compare(2, 1));


System.out.println("===========");
System.out.println("compare.compare(1, 2) = " + compare.compare(new Integer(1), new Integer(2)));
System.out.println("compare.compare(1, 1) = "+compare.compare(new Integer(1), new Integer(1))); // 객체간 비교(==)를 할 경우 다르다고 나온다.
System.out.println("compare.compare(2, 1) = "+compare.compare(new Integer(2), new Integer(1)));

Comparator<Integer> compare2 = (ii, jj) -> {
	int i = ii;
	int j = jj;
	return (i > j) ? -1 : (i == j ? 0 : 1);
};

System.out.println("compare2.compare(1, 2) = " + compare2.compare(new Integer(1), new Integer(2)));
System.out.println("compare2.compare(1, 1) = "+compare2.compare(new Integer(1), new Integer(1))); // int로 언박싱을 한 후 정상동작함을 확인할 수 있다.
System.out.println("compare2.compare(2, 1) = "+compare2.compare(new Integer(2), new Integer(1)));
```

### 초기화되지 않은 박싱타입을 꺼낼 때
- 만약 아래와 같이 초기화되지 않은 값을 꺼내려고 할 때 NullPointerException이 발생한다.
- 이 경우 선언을 Integer가 아닌 int로 하면 해결된다.

```java
Integer i;

@Test
void nullPoint() {
	if(i>100)
		System.out.println(i+"는 100보다 크다");
}
```

### 박싱타입으로 연산할 때
- 연산을 하거나 자바에서 값을 사용할 때 방식타입을 열어서 기본타입만을 사용한다.
- 만약 복잡하고 반복적인 연산이 발생할 경우, 박싱타입을 열고 닫고를 계속 반복해야 한다.
- 실제로 아래의 테스트를 한 결과 약 24배의 차이가 발생했다.

```java
Long boxedLong = 0l;
long primitiveLong = 0l;


long start1 = System.currentTimeMillis();
for(int i=0; i<Integer.MAX_VALUE; i++) {
	boxedLong += i;
}
System.out.println("첫 번째 시간 : "+(start1-System.currentTimeMillis()));

long start2 = System.currentTimeMillis();
for(int i=0; i<Integer.MAX_VALUE; i++) {
	primitiveLong += i;
}
System.out.println("두 번째 시간 : "+(start2-System.currentTimeMillis()));
```

### 정리
- 불가피한 상황이 아닐 경우, 박싱타입은 사용하지 않는다.

## 62 다른 타입이 적절하다면 문자열 사용을 피하라

## 63 문자열 연결은 느리니 주의하라
- String 보다 StringBuilder를 사용한다.

## 64 객체는 인터페이스를 사용해 참조하라
- 이펙티브자바는 일관되게 인터페이스 활용을 권장한다. 선언할 때 마찬가지로 구현 클래스가 아닌 인터페이스로 한다. 성능이나 사용 등 다양한 이유에서 구현 클래스를 변경할 때, 유연하게 대응할 수 있다.
- 불가피하게 인터페이스로 선언할 수 없으면, 클래스 계층 구조 중 가장 덜 구체적인(상위) 클래스를 사용한다.

```java
Set<String> set1 = new HashSet<>(); // 좋은 예
HashSet<String> set2 = new HashSet<>(); // 나쁜 예
```

## 65 리플렉션보다는 인터페이스를 사용하라
- 리플렉션은