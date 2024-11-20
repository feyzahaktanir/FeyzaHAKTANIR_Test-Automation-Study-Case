package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class RequestBodyLoader {
    private final String filePath;

    public RequestBodyLoader(String filePath) {
        this.filePath = filePath;
    }

    public String loadAndReplace(Map<String, String> replacements) throws IOException {
        // Load the request body from the file
        String requestBody = new String(Files.readAllBytes(Paths.get(filePath)));

        // Replace placeholders in the request body with actual values
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            String placeholder = "@" + entry.getKey() + "@";
            String replacement = entry.getValue() != null ? entry.getValue() : "null";
            requestBody = requestBody.replace(placeholder, replacement);
        }

        return requestBody;
    }
}
