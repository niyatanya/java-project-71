package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> data) throws Exception {
        List<String> resultList = new LinkedList<>();

        for (Map<String, Object> map : data) {
            String change = (String) map.get("change");
            switch (change) {
                case "updated":
                    resultList.add("  - "
                            + map.get("name")
                            + ": "
                            + map.get("initValue"));
                    resultList.add("  + "
                            + map.get("name")
                            + ": "
                            + map.get("newValue"));
                    break;
                case "removed":
                    resultList.add("  - "
                            + map.get("name")
                            + ": "
                            + map.get("initValue"));
                    break;
                case "added":
                    resultList.add("  + "
                            + map.get("name")
                            + ": "
                            + map.get("newValue"));
                    break;
                case "same":
                    resultList.add("    "
                            + map.get("name")
                            + ": "
                            + map.get("initValue"));
                    break;
                default:
                    throw new Exception("Unknown change status " + map.get("change"));
            }
        }
        return "{\n"
                + String.join("\n", resultList)
                + "\n}";
    }
}
