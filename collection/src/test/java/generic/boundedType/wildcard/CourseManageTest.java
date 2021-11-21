package generic.boundedType.wildcard;

import generic.boundedType.wildcard.persons.HighStudent;
import generic.boundedType.wildcard.persons.Person;
import generic.boundedType.wildcard.persons.Student;
import generic.boundedType.wildcard.persons.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class courseManageTest {

    Course<Person> personCourse = new Course<>("일반인과정", 5);
    Course<Worker> workerCourse = new Course<>("직장인과정", 5);
    Course<Student> studentCourse = new Course<>("학생과정", 5);
    Course<HighStudent> highStudentCourse = new Course<>("고딩과정", 5);

    CourseManage courseManage = new CourseManage();

    @BeforeEach
    void init(){
        personCourse.add(new Person("일반인 홍길동"));
        personCourse.add(new Worker("노동자 김길동"));
        personCourse.add(new Student("학생 송길동"));
        personCourse.add(new HighStudent("고딩 장길동"));

        workerCourse.add(new Worker("노동자 김길동"));

        studentCourse.add(new Student("학생 송길동"));
        studentCourse.add(new HighStudent("고딩 장길동"));

        highStudentCourse.add(new HighStudent("고딩 장길동"));
    }


    @Test
    void wildCard(){
        courseManage.registerCourse(personCourse);
        courseManage.registerCourse(workerCourse);
        courseManage.registerCourse(studentCourse);
        courseManage.registerCourse(highStudentCourse);
    }

    @Test
    void wildAndExtended(){
//        courseManage.registerStudentCourse(personCourse);
//        courseManage.registerStudentCourse(workerCourse);
        courseManage.registerStudentCourse(studentCourse);
        courseManage.registerStudentCourse(highStudentCourse);
    }

    @Test
    void wildAndSuper(){
        courseManage.registerAdultCourse(personCourse);
        courseManage.registerAdultCourse(workerCourse);
//        courseManage.registerAdultCourse(studentCourse);
//        courseManage.registerAdultCourse(highStudentCourse);
    }

}