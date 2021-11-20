package statics;

public class SampleForStatic {
    public static String staticMember;

    public String noneStaticMember;

    public static void staticMethod(){
        System.out.println("call static method");
    }
    public void noneStaticMethod(){
        System.out.println("call none static method");
    }

    public void callStaticMemberByNoneStaticMethod(){
        System.out.println(staticMember);
    }

//    //컴파일 에러
//    public static void callNoneStaticMemberByStaticMethod(){
//        System.out.println(noneStaticMember);
//    }



    public static String getStaticMember() {
        return staticMember;
    }

    public static void setStaticMember(String staticMember) {
        SampleForStatic.staticMember = staticMember;
    }

    public String getNoneStaticMember() {
        return noneStaticMember;
    }

    public void setNoneStaticMember(String noneStaticMember) {
        this.noneStaticMember = noneStaticMember;
    }

}
