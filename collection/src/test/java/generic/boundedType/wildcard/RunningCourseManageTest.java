package generic.boundedType.wildcard;

import generic.boundedType.wildcard.persons.HighStudent;
import generic.boundedType.wildcard.persons.Person;
import generic.boundedType.wildcard.persons.Student;
import generic.boundedType.wildcard.persons.Worker;
import generic.boundedType.wildcard.types.RunningType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunningCourseManageTest {


    RunningCourse<Person, RunningType> personJoggingCourse = new RunningCourse<>("일반인과정", 5, RunningType.JOGGING);
    RunningCourse<Worker, RunningType> workerMarathonCourse = new RunningCourse<>("직장인과정", 5, RunningType.MARATHON);
    RunningCourse<Student, RunningType> studentWalkingCourse = new RunningCourse<>("학생과정", 5, RunningType.WALKING);
    RunningCourse<HighStudent, RunningType> highStudentJoggingCourse = new RunningCourse<>("고딩과정", 5, RunningType.JOGGING);

    RunningCourseManage courseManage = new RunningCourseManage();

    @BeforeEach
    void init(){
        personJoggingCourse.add(new Person("일반인 홍길동"));
        personJoggingCourse.add(new Worker("노동자 김길동"));
        personJoggingCourse.add(new Student("학생 송길동"));
        personJoggingCourse.add(new HighStudent("고딩 장길동"));

        workerMarathonCourse.add(new Worker("노동자 김길동"));

        studentWalkingCourse.add(new Student("학생 송길동"));
        studentWalkingCourse.add(new HighStudent("고딩 장길동"));

        highStudentJoggingCourse.add(new HighStudent("고딩 장길동"));
    }


    @Test
    void wildCard(){
        courseManage.registerCourse(personJoggingCourse);
        courseManage.registerCourse(workerMarathonCourse);
        courseManage.registerCourse(studentWalkingCourse);
        courseManage.registerCourse(highStudentJoggingCourse);
    }

    @Test
    void wildAndExtended(){
//        courseManage.registerStudentCourse(personCourse);
//        courseManage.registerStudentCourse(workerCourse);
        courseManage.registerStudentCourse(studentWalkingCourse);
        courseManage.registerStudentCourse(highStudentJoggingCourse);
    }

    @Test
    void wildAndSuper(){
        courseManage.registerAdultCourse(personJoggingCourse);
        courseManage.registerAdultCourse(workerMarathonCourse);
//        courseManage.registerAdultCourse(studentCourse);
//        courseManage.registerAdultCourse(highStudentCourse);
    }


}