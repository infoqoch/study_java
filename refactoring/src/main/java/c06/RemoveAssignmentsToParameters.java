package c06;

import com.fasterxml.jackson.databind.type.ClassStack;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class RemoveAssignmentsToParameters {
    public static void main(String[] args) {
        User user = new User("kim", LocalDate.of(2000, Month.of(5), 14));
        
//        user = updateAccessDate(user);
        user.updateAccessDate();

        System.out.println("회원의 마지막 접속일은? = " + user.lastAccessDate);

    }

    private static User updateAccessDate(User user) {
        return new User(user.getName(), user.getLastAccessDate());
    }

    private static void updateAccessDate1(User user) {
        user.setLastAccessDate(LocalDate.now());
    }

    @Data
    @AllArgsConstructor
    static class User {
        private String name;
        private LocalDate lastAccessDate;

        private void updateAccessDate() {
            lastAccessDate = LocalDate.now();
        }
    }

}
