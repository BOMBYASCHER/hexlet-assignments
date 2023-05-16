package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String stringOfSymbols, String word) {
        String[] symbols = stringOfSymbols.toLowerCase().split("");
        String[] splitWord = word.toLowerCase().split("");
        List<String> splitWordList = Arrays.asList(splitWord);
        List<String> symbolsList = new ArrayList<String>(Arrays.asList(symbols));
        for (String letter: splitWordList) {
            if (symbolsList.contains(letter)) {
                symbolsList.remove(letter);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
