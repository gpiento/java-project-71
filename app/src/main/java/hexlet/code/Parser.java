package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String formatFile) throws Exception {

        switch (formatFile) {
            case "json" -> {
                return Parser.textToJson(data);
            }
            case "yaml" -> {
                return Parser.textToYaml(data);
            }
            default -> throw new Exception("Unknown format: '" + formatFile + "'.");
        }
    }

    public static Map<String, Object> textToJson(String data) {

        if (data == null) {
            return new HashMap<>();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(data, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> textToYaml(String data) {

        if (data == null) {
            return new HashMap<>();
        }

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            return objectMapper.readValue(data, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
