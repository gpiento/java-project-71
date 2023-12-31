package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(final String filePath1,
                                  final String filePath2,
                                  final String fileFormat) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> fileMap1 = objectMapper.readValue(readFile(filePath1), Map.class);
        Map<String, Object> fileMap2 = objectMapper.readValue(readFile(filePath2), Map.class);

        switch (fileFormat) {
            case "plain" -> {
                return Plain.render(fileMap1, fileMap2);
            }
            case "stylish" -> {
                return Stylish.render(fileMap1, fileMap2);
            }
            case "json" -> {
                return Json.render(fileMap1, fileMap2);
            }
            default -> {
                return "Unknown format.";
            }
        }
    }

    public static String generate(final String filePath1, final String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String readFile(final String fileName) {

        Path filePath = Paths.get(fileName).toAbsolutePath().normalize();
        String dataJson;

        try {
            dataJson = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataJson;
    }
}
