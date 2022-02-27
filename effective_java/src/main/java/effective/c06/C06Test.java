package effective.c06;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class C06Test {
    @Test
    void test() {
        wrapper();
        primi();
        wrapper();
        primi();
    }

    private void wrapper() {
        final long startTime = System.currentTimeMillis();
        final int size = Integer.MAX_VALUE;
        Long sum1 = 0l;
        for (int i = 0; i < size; i++) {
            sum1 += Integer.MAX_VALUE * i;
        }
        final long endTime = System.currentTimeMillis() - startTime;
        System.out.println("endTime with obj =" + endTime);
    }

    private void primi() {
        final long startTime = System.currentTimeMillis();
        final int size = Integer.MAX_VALUE;
        long sum1 = 0l;
        for (int i = 0; i < size; i++) {
            sum1 += Integer.MAX_VALUE * i;
        }
        final long endTime = System.currentTimeMillis() - startTime;
        System.out.println("endTime with primitive type =" + endTime);
    }

    @Test
    void test1() {
        Long l1 = 13l;
        Long l2 = 13l;
        System.out.println("(l1==l2) = " + (l1 == l2));

        String s1 = "kim";
        String s2 = "kim";
        System.out.println("(s1==s2) = " + (s1 == s2));
    }


    @Test
    void test3() throws JsonProcessingException {
        // given
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            members.add(new Member());
        }

        // test1
        final long startTime = System.currentTimeMillis();
        for(int i=0; i<1000; i++){
            parseJson(members);
        }
        final long endTime = System.currentTimeMillis() - startTime;
        System.out.println("endTime, generate instance each time =" + endTime);

        // test2
        final long startTime2 = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            parseJsonReusable(members);
        }
        final long endTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("endTime, reusable static util = " + endTime2);

    }

    String parseJson(List<Member> members) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String result = objectMapper.writeValueAsString(members);
        return result;
    }
    static final ObjectMapper objectMapper = new ObjectMapper();

    String parseJsonReusable(List<Member> members) throws JsonProcessingException {
        final String result = objectMapper.writeValueAsString(members);
        return result;
    }

    @Data
    static class Member {
        private String name;
        private int age;

        public Member() {
            name = UUID.randomUUID().toString();
            age = (int) (Math.random() * Integer.MAX_VALUE);
        }
    }


}
