package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage map) {
        Set<Map.Entry<String, String>> swap = map.toMap().entrySet();
        swap.forEach(keyValue -> {
            map.unset(keyValue.getKey());
            map.set(keyValue.getValue(), keyValue.getKey());
        });
    }
}
// END
