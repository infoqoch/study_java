package optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    void 없을경우_다른값으로_데이타타입_입력() {
        OpVo vo = new OpVo();
//		vo.setTarget("hi");
        vo.setTarget(null);
        Optional<String> optional = vo.getTarget();
        String get = optional.orElse(new String("hello")); // 다른 객체로도 생성 가능. 제너릭형태
        System.out.println(get);
    }

    @Test
    void 스트림_사용() {
        OpVo vo = new OpVo();
        vo.setTarget("hi");
        Optional<String> optional = vo.getTarget();
        boolean boo = optional.stream().anyMatch(s -> s.contains("k"));
        System.out.println(boo);
    }

    @Test
    void 단순하며_이상적인_optional_사용() {
        OpVo vo = new OpVo();
        vo.setTarget("hi2");
        Optional<String> optional = vo.getTarget();
        optional.ifPresent(System.out::println);
    }

    @Test
    void 비추천() { // if(vo == null) 과 다를 바가 없음. 의미가 없다.
        OpVo vo = new OpVo();
        vo.setTarget("hi");

        Optional<String> optional = vo.getTarget();
        if(optional.isPresent()) {
            String target = optional.get();
            System.out.println(target);
        }
    }
}

class OpVo {
    private String target;

    public Optional<String> getTarget() { // 이상적인 형태. setter 나 맴버 변수에 사용하지 않아야 함. 그냥 getter에 넣는 것이 가장 이상적임.
        return Optional.ofNullable(target) ;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

