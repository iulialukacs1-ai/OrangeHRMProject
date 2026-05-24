package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(
                    "src/test/resources/config.properties");
            properties.load(file);
            System.out.println("Config incarcat cu succes!");
        } catch (IOException e) {
            System.out.println("Eroare: Nu s-a gasit config.properties!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}