package util;

import exceptions.PropertiesParsingException;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.Properties;

@UtilityClass
public class BotConfigUtil {
    private final Properties botProperties = loadProperties();
    private static Properties loadProperties() {
        try (InputStream input = BotConfigUtil.class.getClassLoader().getResourceAsStream("bot.properties")) {
            Properties properties = new Properties();
            if (input != null) {
                properties.load(input);
            } else {
                throw new PropertiesParsingException("Properties file not found");
            }
            return properties;
        } catch (IOException e) {
            throw new PropertiesParsingException("Error loading bot properties", e);
        }
    }

    public static String getBotUsername() {
        return botProperties.getProperty("botUsername");
    }

    public static String getBotToken() {
        return botProperties.getProperty("botToken");
    }
}