package hexlet.code;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
public class DifferenceCalculator {

    public static List<Map<String, Object>> calculate(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> set = new TreeSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        List<Map<String, Object>> resultList = new LinkedList<>();

        for (String key : set) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                Map<String, Object> map = new HashMap<>(4);
                map.put("name", key);
                map.put("change", "removed");
                map.put("initValue", map1.get(key));
                map.put("newValue", null);
                resultList.add(map);
            } else if (map2.containsKey(key) && !map1.containsKey(key)) {
                Map<String, Object> map = new HashMap<>(4);
                map.put("name", key);
                map.put("change", "added");
                map.put("initValue", null);
                map.put("newValue", map2.get(key));
                resultList.add(map);
            } else if (map2.containsKey(key) && map1.containsKey(key)) {
                if ((String.valueOf(map1.get(key))).equals(String.valueOf(map2.get(key)))) {
                    Map<String, Object> map = new HashMap<>(4);
                    map.put("name", key);
                    map.put("change", "same");
                    map.put("initValue", map1.get(key));
                    map.put("newValue", map2.get(key));
                    resultList.add(map);
                } else {
                    Map<String, Object> map = new HashMap<>(4);
                    map.put("name", key);
                    map.put("change", "updated");
                    map.put("initValue", map1.get(key));
                    map.put("newValue", map2.get(key));
                    resultList.add(map);
                }
            }
        }
        return resultList;
    }
}
