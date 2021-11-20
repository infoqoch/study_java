package statics;

public class DefineStatic {
    public static String staticMember;
    public static double pie = 3.14;

    static {
        staticMember="this static member is defined on static block";
        pie = 3.145;
    }

    private static DefineStatic singleton;

    private DefineStatic() {
    }

    public static DefineStatic getInstance(){
        if(singleton == null){
            System.out.println("새로운 싱글톤을 삽입하고 해당 싱글톤을 리턴합니다.");
            singleton = new DefineStatic();
        }else{
            System.out.println("존재하는 싱글톤을 리턴합니다.");
        }
        return singleton;
    }
}
