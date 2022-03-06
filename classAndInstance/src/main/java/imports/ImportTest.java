package imports;

import java.time.LocalDate;

import static java.time.LocalDateTime.*;

public class ImportTest {
    public static void main(String[] args) {
        System.out.println("java.time.Instant.now() = " + java.time.Instant.now());
        System.out.println("LocalDate.now() = " + LocalDate.now());
        System.out.println("now() = " + now());
    }
}
