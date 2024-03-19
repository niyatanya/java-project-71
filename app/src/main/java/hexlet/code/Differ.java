package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Path file1Path = Paths.get(filePath1).toAbsolutePath().normalize();
        Path file2Path = Paths.get(filePath2).toAbsolutePath().normalize();
        if (!Files.exists(file1Path)) {
            throw new Exception("File '" + file1Path + "' does not exist");
        }
        if (!Files.exists(file2Path)) {
            throw new Exception("File '" + file2Path + "' does not exist");
        }
        String file1Content = Files.readString(file1Path);
        String file2Content = Files.readString(file2Path);
        String file1Type = filePath1.substring(filePath1.indexOf('.') + 1);
        String file2Type = filePath2.substring(filePath2.indexOf('.') + 1);

        Map<String, Object> map1 = Parser.parse(file1Content, file1Type);
        Map<String, Object> map2 = Parser.parse(file2Content, file2Type);

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
        return Formatter.format(resultList, format);
    }
}
