package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Json {

    public static Map<String, Object> parser(String data) throws JsonProcessingException {

        if (data == null) {
            return new HashMap<>();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }
}
