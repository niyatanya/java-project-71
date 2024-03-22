package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String type) throws Exception {
        switch (type) {
            case "json":
                return parseJson(data);
            case "yml": case "yaml":
                return parseYml(data);
            default:
                throw new Exception("Unknown data format: " + type);
        }

    }
    public static Map<String, Object> parseJson(String jsonData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, new TypeReference<>() { });
    }

    public static Map<String, Object> parseYml(String ymlData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(ymlData, new TypeReference<>() { });
    }
}
