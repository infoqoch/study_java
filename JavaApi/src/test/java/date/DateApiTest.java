package date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateApiTest {
    @Test
    void legacyDateApi_threadSafety(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time); // Date 인데  time 이 나오고 time 은 이상한 long 이...

        Date now = new Date();
        now.setTime(335983742343245l); // mutable 함. 그러니까 인스턴스의 값이 가변적임. Thread Safety 하지 아니함.
        System.out.println(now);
    }

    @Test
    void legacyDateApi_DateTypeSafety(){
        GregorianCalendar calendar = new GregorianCalendar(2021, 99, 23); // month 가 5를 넣지만 6월이다. int를 99 로 넣을 수 있다.
        System.out.println(calendar.getTime());
    }

    @Test
    void java8_date_api(){
        Instant instant = Instant.now(); // 컴퓨터용 시간
        LocalDate localDate = LocalDate.now(); // 이하 사람 용
        LocalDateTime localDateTime = LocalDateTime.now(); // OS의 기준에 따라... 만약 AWS 등 해외 서버를 사용한다면 위험할수도?
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); // 설정에 따라... 안전할지도?
    }

    @Test
    void java8_date_api2(){
        LocalDateTime localDateTime = LocalDateTime.of(2021, Month.JULY,7, 10,15);
        System.out.println(localDateTime);
        System.out.println(localDateTime.atZone(ZoneId.of("Asia/Seoul")));

        LocalDateTime now = LocalDateTime.now();

        Duration between = Duration.between(now, localDateTime);
        System.out.println(between.toDays());

        Period period = LocalDate.now().until(LocalDate.of(2022, Month.JULY, 5));
        System.out.println(period.get(ChronoUnit.DAYS));
    }

    @Test
    void formatter(){
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String format = LocalDate.now().format(MMddyyyy);
        System.out.println(format);
    }

    @Test
    void strToLocalDateTime(){
        String target = "2022-03-14 21:38:33";
        final LocalDateTime parse = LocalDateTime.parse(target);
        System.out.println("parse = " + parse);
    }
}
