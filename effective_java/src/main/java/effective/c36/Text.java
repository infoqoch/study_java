package effective.c36;


import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    public void applyStyles(Set<Style> styles) {
        for (Style style : styles) {
            System.out.printf("적용할 스타일은 %s 입니다.\n", style.toString());
        }
    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.UNDERLINE));
    }
}
