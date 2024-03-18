package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatPlain(List<Map<String, Object>> data) throws Exception {
        List<String> resultList = new LinkedList<>();

        for (Map<String, Object> map : data) {
            String change = (String) map.get("change");
            switch (change) {
                case "updated":
                    resultList.add("Property '"
                            + map.get("name")
                            + "' was updated. From "
                            + formatValue(map.get("initValue"))
                            + " to "
                            + formatValue(map.get("newValue")));
                    break;
                case "removed":
                    resultList.add("Property '"
                            + map.get("name")
                            + "' was removed");
                    break;
                case "added":
                    resultList.add("Property '"
                            + map.get("name")
                            + "' was added with value: "
                            + formatValue(map.get("newValue")));
                    break;
                case "same":
                    break;
                default:
                    throw new Exception("Unknown change status " + map.get("change"));
            }
        }
        return String.join("\n", resultList);
    }

    public static String formatValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
