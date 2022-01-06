package utils;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrinter {

    private final String value;
    private int maxLength;

    public PrettyPrinter(Object value) {
        try {
            this.value =  String.valueOf(value);
        }catch (Exception e) {
            throw new IllegalArgumentException("Wapper class 혹은 primitive type 을 넣어주세요");
        }
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getLength() {
        return value.length();
    }

    public String toStringWithSpace() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        for(int i=0; i<maxLength- value.length(); i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int maxLength(int... targets) {
        int max = 0;
        for(int i=0; i<targets.length; i++) {
            if(targets[i]>max)
                max = targets[i];
        }
        return max;
    }
}
