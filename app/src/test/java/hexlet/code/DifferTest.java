package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DifferTest {

    @Test
    public void testGenerateStylishJson() throws Exception {
        String file1Path = "src/test/resources/file1.json";
        String file2Path = "src/test/resources/file2.json";
        String expected = "{\n"
                + "  chars1: [a, b, c]\n"
                + "- chars2: [d, e, f]\n"
                + "+ chars2: false\n"
                + "- checked: false\n"
                + "+ checked: true\n"
                + "- default: null\n"
                + "+ default: [value1, value2]\n"
                + "- id: 45\n"
                + "+ id: null\n"
                + "- key1: value1\n"
                + "+ key2: value2\n"
                + "  numbers1: [1, 2, 3, 4]\n"
                + "- numbers2: [2, 3, 4, 5]\n"
                + "+ numbers2: [22, 33, 44, 55]\n"
                + "- numbers3: [3, 4, 5]\n"
                + "+ numbers4: [4, 5, 6]\n"
                + "+ obj1: {nestedKey=value, isNested=true}\n"
                + "- setting1: Some value\n"
                + "+ setting1: Another value\n"
                + "- setting2: 200\n"
                + "+ setting2: 300\n"
                + "- setting3: true\n"
                + "+ setting3: none\n"
                + "}";
        String actual = Differ.generate(file1Path, file2Path, "stylish");
        assertEquals(expected, actual);
    }

//    @Test
//    public void testGenerateEmptyFile() throws Exception {
//        String file1Path = "src/test/resources/file1.json";
//        String emptyFilePath = "src/test/resources/Empty.json";
//        String expected = "{\n- follow: false\n- host: hexlet.io\n- proxy: 123.234.53.22\n- timeout: 50\n}";
//        String actual = Differ.generate(file1Path, emptyFilePath);
//        assertEquals(expected, actual);
//    }

    @Test
    public void testGenerateStylishYml() throws Exception {
        String file1Path = "src/test/resources/file1.yml";
        String file2Path = "src/test/resources/file2.yml";
        String expected = "{\n"
                + "  chars1: [a, b, c]\n"
                + "- chars2: [d, e, f]\n"
                + "+ chars2: false\n"
                + "- checked: false\n"
                + "+ checked: true\n"
                + "- default: null\n"
                + "+ default: [value1, value2]\n"
                + "- id: 45\n"
                + "+ id: null\n"
                + "- key1: value1\n"
                + "+ key2: value2\n"
                + "  numbers1: [1, 2, 3, 4]\n"
                + "- numbers2: [2, 3, 4, 5]\n"
                + "+ numbers2: [22, 33, 44, 55]\n"
                + "- numbers3: [3, 4, 5]\n"
                + "+ numbers4: [4, 5, 6]\n"
                + "+ obj1: {nestedKey=value, isNested=true}\n"
                + "- setting1: Some value\n"
                + "+ setting1: Another value\n"
                + "- setting2: 200\n"
                + "+ setting2: 300\n"
                + "- setting3: true\n"
                + "+ setting3: none\n"
                + "}";
        String actual = Differ.generate(file1Path, file2Path, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testGeneratePlainJson() throws Exception {
        String file1Path = "src/test/resources/file1.json";
        String file2Path = "src/test/resources/file2.json";
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        String actual = Differ.generate(file1Path, file2Path, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGeneratePlainYml() throws Exception {
        String file1Path = "src/test/resources/file1.yml";
        String file2Path = "src/test/resources/file2.yml";
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        String actual = Differ.generate(file1Path, file2Path, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonJson() throws Exception {
        String file1Path = "src/test/resources/file1.json";
        String file2Path = "src/test/resources/file2.json";
        String expected = "[{\"name\":\"chars1\",\"newValue\":[\"a\",\"b\",\"c\"],\"initValue\":[\"a\",\"b\",\"c\"]"
                + ",\"change\":\"same\"},{\"name\":\"chars2\",\"newValue\":false,\"initValue\":"
                + "[\"d\",\"e\",\"f\"],\"change\":\"updated\"},{\"name\":\"checked"
                + "\",\"newValue\":true,\"initValue\":false,\"change\":\"updated\"},{\"name\":\"default\","
                + "\"newValue\":[\"value1\",\"value2\"],\"initValue\":null,\"change\":\"updated\"},"
                + "{\"name\":\"id\",\"newValue\":null,\"initValue\":45,\"change\":\"updated\"},{\"name\":\"key1\","
                + "\"newValue\":null,\"initValue\":\"value1\",\"change\":\"removed\"},{\"name\":\"key2\",\"newValue"
                + "\":\"value2\",\"initValue\":null,\"change\":\"added\"},{\"name\":\"numbers1"
                + "\",\"newValue\":[1,2,3,4],\"initValue\":[1,2,3,4],\"change\":\"same\"},{\"name\":\"numbers2\","
                + "\"newValue\":[22,33,44,55],\"initValue\":[2,3,4,5],\"change\":\"updated\"},{\"name\":\"numbers3"
                + "\",\"newValue\":null,\"initValue\":[3,4,5],\"change\":\"removed\"},{\"name\":\"numbers4"
                + "\",\"newValue\":[4,5,6],\"initValue\":null,\"change\":\"added\"},{\"name\":\"obj1\",\"newValue"
                + "\":{\"nestedKey\":\"value\",\"isNested\""
                + ":true},\"initValue\":null,\"change\":\"added\"},{\"name\":\"setting1\",\"newValue\":\"Another value"
                + "\",\"initValue\":\"Some value\",\"change\":\"updated\"},{\"name\":\"setting2\",\"newValue\":300,"
                + "\"initValue\":200,\"change\":\"updated\"},{\"name\":\"setting3\",\"newValue\":\"none\",\"initValue"
                + "\":true,\"change\":\"updated\"}]";
        String actual = Differ.generate(file1Path, file2Path, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonYml() throws Exception {
        String file1Path = "src/test/resources/file1.yml";
        String file2Path = "src/test/resources/file2.yml";
        String expected = "[{\"name\":\"chars1\",\"newValue\":[\"a\",\"b\",\"c\"],\"initValue\":[\"a\",\"b\",\"c\"]"
                + ",\"change\":\"same\"},{\"name\":\"chars2\",\"newValue\":false,\"initValue\":"
                + "[\"d\",\"e\",\"f\"],\"change\":\"updated\"},{\"name\":\"checked"
                + "\",\"newValue\":true,\"initValue\":false,\"change\":\"updated\"},{\"name\":\"default\","
                + "\"newValue\":[\"value1\",\"value2\"],\"initValue\":null,\"change\":\"updated\"},"
                + "{\"name\":\"id\",\"newValue\":null,\"initValue\":45,\"change\":\"updated\"},{\"name\":\"key1\","
                + "\"newValue\":null,\"initValue\":\"value1\",\"change\":\"removed\"},{\"name\":\"key2\",\"newValue"
                + "\":\"value2\",\"initValue\":null,\"change\":\"added\"},{\"name\":\"numbers1"
                + "\",\"newValue\":[1,2,3,4],\"initValue\":[1,2,3,4],\"change\":\"same\"},{\"name\":\"numbers2\","
                + "\"newValue\":[22,33,44,55],\"initValue\":[2,3,4,5],\"change\":\"updated\"},{\"name\":\"numbers3"
                + "\",\"newValue\":null,\"initValue\":[3,4,5],\"change\":\"removed\"},{\"name\":\"numbers4"
                + "\",\"newValue\":[4,5,6],\"initValue\":null,\"change\":\"added\"},{\"name\":\"obj1\",\"newValue"
                + "\":{\"nestedKey\":\"value\",\"isNested\""
                + ":true},\"initValue\":null,\"change\":\"added\"},{\"name\":\"setting1\",\"newValue\":\"Another value"
                + "\",\"initValue\":\"Some value\",\"change\":\"updated\"},{\"name\":\"setting2\",\"newValue\":300,"
                + "\"initValue\":200,\"change\":\"updated\"},{\"name\":\"setting3\",\"newValue\":\"none\",\"initValue"
                + "\":true,\"change\":\"updated\"}]";
        String actual = Differ.generate(file1Path, file2Path, "json");
        assertEquals(expected, actual);
    }
}
