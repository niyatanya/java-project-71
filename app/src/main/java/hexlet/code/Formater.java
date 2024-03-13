package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

public class Formater {
    public static String format(Map<String, String> result, String format) throws Exception {

        switch (format) {
            case "stylish":
                return "{\n"
                        + result.entrySet()
                        .stream()
                        .map(e -> e.getKey() + ": " + e.getValue())
                        .collect(Collectors.joining("\n"))
                        + "\n}";
            default:
                throw new Exception("Unknown format " + format);
        }
    }
}
