package inner.places;

public class SampleLocalClass {
    String instanceField = "instanceField";
    static String staticField = "staticField";

    void sampleMethod(String arg){
        String localVar = "localVar";

        class LocalClass{
            void accessVars(){
                instanceField = "hi!";
                staticField = "hi!";
                // localVar = "hi!"; // final이라서 수정불가
                // arg = "hi!"; // final이라서 수정불가
            }
        }
    }
}
