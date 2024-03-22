package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
public class DifferenceCalculator {

    public static List<Map<String, Object>> calculate(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> set = new TreeSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        List<Map<String, Object>> resultList = new LinkedList<>();

        for (String key : set) {
            if (!map2.containsKey(key)) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("name", key);
                map.put("change", "removed");
                map.put("initValue", map1.get(key));
                map.put("newValue", null);
                resultList.add(map);
            } else if (!map1.containsKey(key)) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("name", key);
                map.put("change", "added");
                map.put("initValue", null);
                map.put("newValue", map2.get(key));
                resultList.add(map);
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("name", key);
                map.put("change", "same");
                map.put("initValue", map1.get(key));
                map.put("newValue", map2.get(key));
                resultList.add(map);
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("name", key);
                map.put("change", "updated");
                map.put("initValue", map1.get(key));
                map.put("newValue", map2.get(key));
                resultList.add(map);
            }
        }
        return resultList;
    }
}
