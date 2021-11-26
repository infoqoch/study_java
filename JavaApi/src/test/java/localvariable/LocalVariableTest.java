package localvariable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTest {

    @Test
    void test_object() {
        Tester tester = new Tester();
        tester.setName("홍길동");
        innerMethod_object(tester);
        System.out.println(tester.getName());
        System.out.println(tester.getCity());
    }

    private void innerMethod_object(Tester tester) {
        tester.setCity("서울");
    }

    @Test
    private void test_collection_list() {
        List<String> list = new ArrayList<>();
        list.add("outer");
        innerMethod_collection(list);
        list.stream().forEach(System.out::println);
    }

    private void innerMethod_collection(List<String> list) {
        list.add("inner");
    }

    @Test
    @DisplayName("이 테스트만 리턴하지 아니하면 값의 변화가 없음")
    private void test_primitive_wrapper_string() {
        int a = 0;
        innerMethod_primitive(a);
        System.out.println(a);

        Integer A = 0;
        innerMethod_wrapper(A);
        System.out.println(A);

        String str = "hi";
        innerMethod_string(str);
        System.out.println(str);
    }

    private void innerMethod_string(String a) {
        a = "hihi";
    }

    private void innerMethod_wrapper(Integer a) {
        a += 100;
    }

    private void innerMethod_primitive(int a) {
        a += 100;
    }
}

class Tester {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
