# Stream api 
## 스트림의 특징
- 데이터를 수정하지 않는다. stream 은 그저 데이터의 처리 로직이다. (중계 오퍼레이션)
- stream 이 아닌 값을 return 하는 것을 종료 오퍼레이션이라 한다. 종료 오퍼레이션을 만날 때 스트림은 동작한다. lazy
- 한 개 이상의 중계 오퍼레이션과 하나의 종료 오퍼레이션의 모음을 스트림 파이프라인이라 한다.

## 스트림에 있어서 몇 가지 재밌었던 것들 
### flatMap
- List<List<Something>> 을 List<Something> 형태로 바꾼다.

### iterator, skip, limit
- iterator 는 일종의 스트림 생성 기능이다. iterate(T, M) 이며 function 처럼 T는 인자 M 은 리턴하여 하나의 스트림을 생성한다.
- skip 은 해당 스트림에서 몇 번을 continue 하는지를 의미하며 limit 은 시작점으로부터 몇 개를 가져오는지를 의미한다. skip(10).limit(20) 이면 처음부터 10까지 무시하고 11부터 20개를 가지고 온다. 
