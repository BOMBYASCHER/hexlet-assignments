package exercise;

import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter((user) -> user.get("gender").equals("male"))
                .sorted((man1, man2) -> {
                    LocalDate date1 = LocalDate.parse(man1.get("birthday"));
                    LocalDate date2 = LocalDate.parse(man2.get("birthday"));
                    return date1.compareTo(date2);
                })
                .map(man -> man.get("name"))
                .collect(Collectors.toList());
    }
}
// END
