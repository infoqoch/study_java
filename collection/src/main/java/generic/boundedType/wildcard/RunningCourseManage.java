package generic.boundedType.wildcard;

import generic.boundedType.wildcard.persons.Student;
import generic.boundedType.wildcard.persons.Worker;
import generic.boundedType.wildcard.types.RunningType;

public class RunningCourseManage extends CourseManage{

    public void registerCourse(RunningCourse<?, RunningType> course) {
        super.registerCourse(course);
        System.out.println("러닝 종류 : "+course.getRunningType());
    }

    public void registerStudentCourse(RunningCourse<? extends Student, RunningType> course) {
        super.registerStudentCourse(course);
        System.out.println("러닝 종류 : "+course.getRunningType());
    }

    public void registerAdultCourse(RunningCourse<? super Worker, RunningType> course) {
        super.registerAdultCourse(course);
        System.out.println("러닝 종류 : "+course.getRunningType());
    }
}
