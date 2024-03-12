package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DifferTest {

    @Test
    public void testGenerate() throws Exception {
        String file1Path = "src/test/resources/file1.json";
        String file2Path = "src/test/resources/file2.json";
        String expected = "{\n- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n"
                + "+ timeout: 20\n+ verbose: true\n}";
        String actual = Differ.generate(file1Path, file2Path);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateEmptyFile() throws Exception {
        String file1Path = "src/test/resources/file1.json";
        String emptyFilePath = "src/test/resources/Empty.json";
        String expected = "{\n- follow: false\n- host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n}";
        String actual = Differ.generate(file1Path, emptyFilePath);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYML() throws Exception {
        String file1Path = "src/test/resources/file1.yml";
        String file2Path = "src/test/resources/file2.yml";
        String expected = "{\n- follow: false\n  host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n"
                + "+ timeout: 20\n+ verbose: true\n}";
        String actual = Differ.generate(file1Path, file2Path);
        assertEquals(expected, actual);
    }
}
