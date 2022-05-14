package liskov;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void test1() {
        Rectangle rec = new Square();
        rec.setWidth(10);
        assertThat(rec.area()).isEqualTo(100);
    }

    @Test
    void test2() {
        Rectangle rec = new Square();
        rec.setWidth(10);
        rec.setHeight(20);
        assertThat(rec.area()).isEqualTo(200);
    }
}