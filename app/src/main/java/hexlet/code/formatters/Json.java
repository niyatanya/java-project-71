package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String formatJson(List<Map<String, Object>> data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}
