package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        System.out.println("> generate()");
        System.out.println("filePath1: " + filePath1);
        System.out.println("filePath2: " + filePath2);

        Path file1Path = Paths.get(filePath1).toAbsolutePath().normalize();
        Path file2Path = Paths.get(filePath2).toAbsolutePath().normalize();
        if (!Files.exists(file1Path)) {
            throw new Exception("File '" + file1Path + "' does not exist");
        }
        if (!Files.exists(file2Path)) {
            throw new Exception("File '" + file2Path + "' does not exist");
        }

        System.out.println("try to read all files");

        String jsonFile1 = Files.readString(file1Path);
        String jsonFile2 = Files.readString(file2Path);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(jsonFile1, new TypeReference<>() { });
        Map<String, Object> map2 = objectMapper.readValue(jsonFile2, new TypeReference<>() { });

        Set<String> set = new TreeSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        Map<String, String> resultMap = new LinkedHashMap<>();

        for (String key : set) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                String newKey = "- " + key;
                resultMap.put(newKey, map1.get(key).toString());
            } else if (map2.containsKey(key) && !map1.containsKey(key)) {
                String newKey = "+ " + key;
                resultMap.put(newKey, map2.get(key).toString());
            } else if (map2.containsKey(key) && map1.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    String newKey = "  " + key;
                    resultMap.put(newKey, map1.get(key).toString());
                } else {
                    String newKey1 = "- " + key;
                    resultMap.put(newKey1, map1.get(key).toString());
                    String newKey2 = "+ " + key;
                    resultMap.put(newKey2, map2.get(key).toString());
                }
            }
        }

        String result = resultMap.entrySet()
                .stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining("\n"));
        return "{\n" + result + "\n}";
    }
}
