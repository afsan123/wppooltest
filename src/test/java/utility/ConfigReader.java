package utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    private static final String CONFIG_FILE_PATH = "config.json";

    public static String getAppUrl() {
        try (FileReader fileReader = new FileReader(CONFIG_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("appUrl").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getUsername() {
        try (FileReader fileReader = new FileReader(CONFIG_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("username").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getPassword() {
        try (FileReader fileReader = new FileReader(CONFIG_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
            return jsonObject.get("password").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
