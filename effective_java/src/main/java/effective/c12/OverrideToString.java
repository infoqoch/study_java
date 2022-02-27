package effective.c12;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class OverrideToString {
    private String name;
    private int age;
    private String school;

    @Override
    public String toString() {
        return "안녕하세요, 저는 "+name+"입니다. 나이는 "+age+"이며, 현재 다니는 학교는 "+school+"입니다.";
    }
}
