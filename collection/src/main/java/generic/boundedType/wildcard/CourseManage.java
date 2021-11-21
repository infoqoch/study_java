package generic.boundedType.wildcard;

import generic.boundedType.wildcard.persons.Student;
import generic.boundedType.wildcard.persons.Worker;

import java.util.Arrays;

public class CourseManage {

    public void registerCourse(Course<?> course){ // 와일드카드. 아무것이나 들어갈 수 있다.
        System.out.println("수업 : "+course.getName());
        System.out.println("수강생 : "+ Arrays.toString(course.getStudents()));
    }

    public void registerStudentCourse(Course<? extends Student> course){ // Student 와 Student 보다 하위 타입만 가능하다.
        System.out.println("수업 : "+course.getName());
        System.out.println("수강생 : "+ Arrays.toString(course.getStudents()));
    }

    public void registerAdultCourse(Course<? super Worker> course){ // Worker 와 Worker 보다 상위 타입만 가능하다.
        System.out.println("수업 : "+course.getName());
        System.out.println("수강생 : "+ Arrays.toString(course.getStudents()));
    }

}
