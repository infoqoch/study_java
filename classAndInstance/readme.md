# Class 및 Instance
## static
- static 은 객체를 생성하지 않고 사용할 수 있는 필드와 메소드를 말한다.
- JVM 이 클래스로더 시점에 적재되는 데이터로서, 메소드 메모리 영역에 저장된다. 그러므로 클래스로딩 이후 어디서든 사용 가능하다. 

### 싱글톤
- 싱글톤의 객체는 static 이다. 그러므로 사실상 getInstance() 를 스프링이 호출할 때는 이미 한 번 호출하고 난 다음 호출하는 것과 같다.
- 스프링 부트 웹 구현체에서 실제로 진행해봤다. 여기서 하기는 복잡하니까!

#### 실제 구현 내용
```java
package hello.aop.hi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestSingleton {
    public static TestSingleton singleton;

    private TestSingleton() {
        log.info("[TestSingleton logging] private 생성자!");
    }

    public static TestSingleton getInstance(){
        if(singleton == null){
            log.info("새로운 싱글톤을 삽입하고 해당 싱글톤을 리턴합니다.");
            singleton = new TestSingleton();
        }else{
            log.info("존재하는 싱글톤을 리턴합니다.");
        }
        return singleton;
    }
}

```

#### 로그의 내용
```text
2021-11-21 03:27:06.032  INFO 14124 --- [           main] hello.aop.hi.TestSingleton               : [TestSingleton logging] private 생성자!
2021-11-21 03:27:07.316  INFO 14124 --- [           main] hello.aop.exam.ExamTest                  : Started ExamTest in 3.455 seconds (JVM running for 5.723)
2021-11-21 03:27:07.815  INFO 14124 --- [           main] hello.aop.hi.TestSingleton               : 새로운 싱글톤을 삽입하고 해당 싱글톤을 리턴합니다.
```