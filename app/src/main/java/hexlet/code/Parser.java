package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String fileContent, String fileType) throws Exception {
        switch (fileType) {
            case "json":
                return parseJson(fileContent);
            case "yml":
                return parseYml(fileContent);
            default:
                throw new Exception("Unknown data format: " + fileType);
        }

    }
    public static Map<String, Object> parseJson(String jsonFileContent) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonFileContent, new TypeReference<>() { });
    }

    public static Map<String, Object> parseYml(String ymlFileContent) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(ymlFileContent, new TypeReference<>() { });
    }
}
