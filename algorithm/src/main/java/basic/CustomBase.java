package basic;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CustomBase {

    @Test
    void 예외_연습(){
        assertThatThrownBy(() -> {throw new RuntimeException();})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 임의의_진수_만들기(){

        List<CustomBaseSample> list = new ArrayList<>();
        final CustomBaseSample build = CustomBaseSample.builder().base(10).decimal(0).ex(true).build();
        list.add(build);
        list.add(CustomBaseSample.builder().base(0).decimal(10).ex(true).build());
        list.add(CustomBaseSample.builder().base(0).decimal(999).ex(true).build());
        list.add(CustomBaseSample.builder().base(20).decimal(0).ex(true).build());
        list.add(CustomBaseSample.builder().base(32).decimal(123).expect("3R").ex(false).build());
        list.add(CustomBaseSample.builder().base(2).decimal(345).expect("101011001").ex(false).build());
        list.add(CustomBaseSample.builder().base(2).decimal(345).expect("101011001").ex(false).build());
        list.add(CustomBaseSample.builder().base(16).decimal(777645).expect("BDDAD").ex(false).build());
        list.add(CustomBaseSample.builder().base(8).decimal(3453452).expect("15131014").ex(false).build());

        for(int i=0; i<list.size(); i++){
            CustomBaseSample sample = list.get(i);
            if(sample.isEx() == true){
                assertThatThrownBy(() ->
                        converter(sample.getBase(), sample.getDecimal(), get36Base()))
                        .isInstanceOf(IllegalArgumentException.class);
            }else{
                final String result = converter(sample.getBase(), sample.getDecimal(), get36Base());
                assertThat(result).isEqualTo(sample.getExpect());
            }
        }
    }

    private String converter(int base, int decimal, String base36) {
        if(base<=0 || decimal <=0 || base > 32)
            throw new IllegalArgumentException("정상값을 입력하세요!");

        int quotient = decimal;
        StringBuilder sb = new StringBuilder();

        do{
            sb.append(base36.charAt(quotient% base));
            quotient/= base;
        }while(quotient>0);
        String result = sb.reverse().toString();
        System.out.printf("%d를 %d진법으로 바꾸면 %s입니다.\n", decimal, base, result);
        return result;
    }

    private String get36Base() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(i);
        }
        for(int i=65; i<65+26; i++) {
            sb.append((char) i);
        }
        String base36 = sb.toString();
        return base36;
    }
}

@Builder
@Getter
@ToString
class CustomBaseSample{
    int base;
    int decimal;
    String expect;
    boolean ex;
}
