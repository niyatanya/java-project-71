package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> data, String format) throws Exception {

        switch (format) {
            case "stylish":
                return Stylish.formatStylish(data);
            case "plain":
                return Plain.formatPlain(data);
            case "json":
                return Json.formatJson(data);
            default:
                throw new Exception("Unknown format " + format);
        }
    }
}
