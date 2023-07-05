package exercise;
// import java.util.Arrays;
import java.util.Arrays;

// BEGIN
class App {
    static String[] increaseArray(String[] array) {
        String[] result = new String[array.length * 2];
        int i = 0;
        for (String s : array) {
            result[i] = s;
            result[i + 1] = s;
            i += 2;
        }
        return result;
    }
    static String[][] duplicate(String[] array) {
        return new String[][]{array, array};
    }
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(App::increaseArray)
                .map(App::duplicate)
                .flatMap(Arrays::stream)
                .toArray(String[][]::new);
    }
}
// END
