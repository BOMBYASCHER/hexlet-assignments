package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.length() == 0) {
            return new HashMap<>();
        }
        Map<String, Integer> words = new HashMap<>();
        String[] splitSentence = sentence.split(" ");
        for (String word: splitSentence) {
            if (words.containsKey(word)) {
                words.replace(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
        return words;
    }
    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        String result = "";
        for (String word: map.keySet()) {
            result = result + "  " + word + ": " + map.get(word) + "\n";
        }
        return "{\n" + result + "}";
    }
}
//END
