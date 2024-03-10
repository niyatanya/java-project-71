package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {
    private String jsonFile1;
    private String jsonFile2;
    private String expected;

    @BeforeEach
    public void prepare() throws Exception {
        Path file1Path = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        jsonFile1 = Files.readString(file1Path);
        Path file2Path = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();
        jsonFile2 = Files.readString(file2Path);
        if (!Files.exists(file1Path)) {
            throw new Exception("File '" + file1Path + "' does not exist");
        }
        if (!Files.exists(file2Path)) {
            throw new Exception("File '" + file2Path + "' does not exist");
        }
        expected = "{\n- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n"
                + "+ timeout: 20\n+ verbose: true\n}";
    }

    @Test
    public void testGenerate() throws Exception {
        String actual = Differ.generate(jsonFile1, jsonFile2);
        assertEquals(expected, actual);
    }

}
