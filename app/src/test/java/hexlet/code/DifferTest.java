package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }
    @Test
    public void testGenerateStylishJson() throws Exception {
        String file1Path = "src/test/resources/fixtures/file1.json";
        String file2Path = "src/test/resources/fixtures/file2.json";
        String expected = resultStylish;
        String actual = Differ.generate(file1Path, file2Path, "stylish");
        System.out.println("DEBUG. Expected line length: " + expected.length());
        System.out.println("DEBUG. Actual line length: " + actual.length());
        assertEquals(expected, actual);
    }

//    @Test
//    public void testGenerateStylishYml() throws Exception {
//        String file1Path = "src/test/resources/fixtures/file1.yml";
//        String file2Path = "src/test/resources/fixtures/file2.yml";
//        String expected = resultStylish;
//        String actual = Differ.generate(file1Path, file2Path, "stylish");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGeneratePlainJson() throws Exception {
//        String file1Path = "src/test/resources/fixtures/file1.json";
//        String file2Path = "src/test/resources/fixtures/file2.json";
//        String expected = resultPlain;
//        String actual = Differ.generate(file1Path, file2Path, "plain");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGeneratePlainYml() throws Exception {
//        String file1Path = "src/test/resources/fixtures/file1.yml";
//        String file2Path = "src/test/resources/fixtures/file2.yml";
//        String expected = resultPlain;
//        String actual = Differ.generate(file1Path, file2Path, "plain");
//        assertEquals(expected, actual);
//    }
//
    @Test
    public void testGenerateJsonJson() throws Exception {
        String file1Path = "src/test/resources/fixtures/file1.json";
        String file2Path = "src/test/resources/fixtures/file2.json";
        String expected = resultJson;
        String actual = Differ.generate(file1Path, file2Path, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonYml() throws Exception {
        String file1Path = "src/test/resources/fixtures/file1.yml";
        String file2Path = "src/test/resources/fixtures/file2.yml";
        String expected = resultJson;
        String actual = Differ.generate(file1Path, file2Path, "json");
        assertEquals(expected, actual);
    }
//    @Test
//    public void testGenerateDefaultJson() throws Exception {
//        String file1Path = "src/test/resources/fixtures/file1.json";
//        String file2Path = "src/test/resources/fixtures/file2.json";
//        String expected = resultStylish;
//        String actual = Differ.generate(file1Path, file2Path);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGenerateDefaultYml() throws Exception {
//        String file1Path = "src/test/resources/fixtures/file1.yml";
//        String file2Path = "src/test/resources/fixtures/file2.yml";
//        String expected = resultStylish;
//        String actual = Differ.generate(file1Path, file2Path);
//        assertEquals(expected, actual);
//    }
}
