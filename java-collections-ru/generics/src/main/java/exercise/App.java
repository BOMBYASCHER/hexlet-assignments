package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> params) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            if (book.entrySet().containsAll(params.entrySet())) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
