package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeDomains = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");
        long result = emails.stream()
                .filter(email -> freeDomains.contains(email.split("@")[1]))
                .count();
        return result;
    }
}
// END
