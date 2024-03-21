package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
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

        List<Map<String, Object>> resultList = DifferenceCalculator.calculate(map1, map2);

        return Formatter.format(resultList, format);
    }
}
