package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String file) {
        return Arrays.stream(file.split("\n"))
                .filter(string -> string.startsWith("environment"))
                .flatMap(string -> Arrays.stream(string.
                                substring(string.indexOf("\"") + 1, string.length() - 1)
                                .split(","))
                        .filter(variables -> variables.startsWith("X_FORWARDED_"))
                        .map(forwarded -> forwarded.replaceAll("X_FORWARDED_", "")))
                .collect(Collectors.joining(","));
    }
}
//END
