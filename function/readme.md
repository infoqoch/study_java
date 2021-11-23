# 함수
- 자바 기본을 공부하는 김에 함수, 람다도 공부하자!

## 함수
### 함수란?
- 객체지향적인 언어인 자바는 기본적으로 모든 것이 객체이다.
- 인자와 결과로 이뤄진 매서드는, 그것의 요구사항(추상 클래스, 인터페이스)에 따라 새로운 클래스에 구현한다. 하지만 자바에서는 익명 구현 객체라 하여, 새로운 클래스를 만들지 않고 바로 해당 로직을 구현할 수 있도록 하였다. 자바 8 부터는 람다로 형태로 구현할 수 있다. 이러한 것을 함수라 한다.   
- 익명 구현 객체는 functionalInterface 를 인자로 할 때 가능하다. 함수적 인터페이스란 구현 매서드가 하나인 인터페이스를 의미한다.
- 함수적 인터페이스는 앞서 프록시 때 공부한 것처럼, 탬플릿 패턴, 전략 패턴, 콜백 패턴의 형태를 띈다.  
- 자바는 이미 내장된 functionalInterface 를 가지고 있으며, 이를 사용할 수 있다.  

### 순수한 함수?
- 더 나아가 순수한 함수란 개념이 있다. 이는 같은 함수에 같은 인자를 넣을 경우 계속 동일한 값을 출력하는 것을 보장한다.
- 이러한 보장에 있어서 가장 중요한 요소는, 함수가 외부의 변수를 참조하지 않는 원칙을 지키는 것이다.
- 실제로 자바에서는 익명 구현 객체나 람다가 참조하는 외부 변수가 final 로 지정하지 않아도 암묵적으로 final 을 지시자로 한다.

### Function<T, M>
- 자바가 제공하는 functional interface 중 하나인 Function 을 보자. 
- Function<String, Integer> function = s -> s.length(); 
- 위의 내용을 익명함수로 표현하자면 다음처럼 된다. 매우 간단하게 표현 됨을 알 수 있다. 
```java
    new Function<String, Integer>() {
    
    @Override
    public Integer apply(String s) {
        return s.length();
        }
    }
```
- Function 이외에 Supplier, Consumer, Operator 등 다양한 함수인터페이스가 존재한다.

## 람다의 매서드 참조
- 람다는 매서드를 아주 간편하게 참조할 수 있다. 
```java
Function<Long, String> referStaticMethod = String::valueOf; // static method 의 활용. String.valueOf(wrapper class, primitive type) => return String

boolean h = "hi".startsWith("h");
BiFunction<String,String,Boolean> referInstanceMethod1 = (s, s2) -> s.startsWith(s2);
BiFunction<String,String,Boolean> referInstanceMethod2 = String::startsWith;
```
- 전자는 static method 로서 Function 과 인자와 리턴이 같다. Long 을 인자로 하여 String 을 리턴한다. 
- 후자는 interface method 로서, String 두 개를 필요로 한다. 모양은 마치 String 의 static 매서드를 사용하는 것 같지만, 사실은 String 의 인스턴스 매서드를 사용하며, 그것의 인자 두 개가 Function 의 제너릭을 정의할 때의 데이타타입이 일치하여 가능한 구현 방식이다.
- 이렇게 람다를 통해 매우 짧고 간결하게 구현 가능하다. 

## 인터페이스의 default
- 인터페이스는 override 를 기본으로 하지만 default 를 통해 override 를 하지 않고 어떤 구현 객체에서나 접근 가능하다.
- default 는 abstract method 의 구현을 가정하고 활용하거나 조작하는 방식으로 구현 가능하다.
- 필요에 따라 충돌 상황에 따라 default 는 override 할 수 있다. 