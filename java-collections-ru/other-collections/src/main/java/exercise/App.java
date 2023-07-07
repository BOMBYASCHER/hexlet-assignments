package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> set = new TreeSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        set.forEach(key -> {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else {
                if (map1.containsKey(key)) {
                    result.put(key, "deleted");
                } else {
                    result.put(key, "added");
                }
            }
        });
        return result;
    }
}
//END
