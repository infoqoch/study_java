package effective.c07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class SampleStackTest {

//    @Test
    void isWorking(){
        SampleStack stack = new SampleStack();

        stack.push(LocalDateTime.now());
        stack.push("kjim");

        String kim = (String) stack.pop();
        System.out.println("kim : "+kim);

        LocalDateTime date = (LocalDateTime) stack.pop();
        System.out.println("date : "+date);

        try {
            stack.pop();
        }catch (Exception e) {
            System.out.println("error : "+e.getMessage());
        }

    }

    @Test
    void test() {
        SampleStack stack = new SampleStack();

        for(int i=0; i<10; i++) {
            stack.push(LocalDateTime.now().plusDays(i));
        }

        stack.print();

        for(int i=0; i<10; i++) {
            stack.pop();
        }

        stack.print(); // pop이 되었으나 해당 객체는 살아있다.
    }

    @Test
    void test2() {
        SampleStack stack = new SampleStack();

        for(int i=0; i<10; i++) {
            stack.push(LocalDateTime.now().plusDays(i));
        }

        stack.print();

        for(int i=0; i<10; i++) {
            stack.popV2();
        }

        stack.print(); // 더 이상 객체가 살아있지 않고 제거된다.
    }

}
