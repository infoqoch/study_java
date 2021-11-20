package statics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleForStaticTest {

    @Test
    @DisplayName("static 은 Class 에서만 호출할 수 있다. ")
    void callStatics(){
        SampleForStatic.setStaticMember("hi");
        System.out.println(SampleForStatic.getStaticMember());
        SampleForStatic.staticMethod();

    }

    @Test
    @DisplayName("none static 은 객체에서만 호출할 수 있다. ")
    void callNoneStatics(){
        SampleForStatic sampleForStatic = new SampleForStatic();
        sampleForStatic.setNoneStaticMember("called by instance");
        System.out.println(sampleForStatic.getNoneStaticMember());
        sampleForStatic.noneStaticMethod();
    }

    @Test
    @DisplayName("static Member 는 non static method 에게 호출이 되나, none static member 는 static method 에게 호출되지 않는다. 전자의 동작 여부는 크게 문제가 없을 것 같다. 그런데 후자는 성립될 수 없다. 객체를 통해 생성되는 값을 static 상태에서 호출할 수는 없을 테니까. ")
    void callNoneStatics1(){
        SampleForStatic sampleForStatic = new SampleForStatic();
        SampleForStatic.setStaticMember("I am a staticMember and called by a instance");
        sampleForStatic.callStaticMemberByNoneStaticMethod();
    }
}