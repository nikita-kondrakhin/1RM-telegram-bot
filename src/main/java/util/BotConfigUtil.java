package util;

import exceptions.PropertiesParsingException;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

@UtilityClass
public class BotConfigUtil {
    private final String PROPERTIES_FILE_NAME = "bot.properties";
    private final String BOT_USERNAME_KEY = "botUsername";
    private final String BOT_TOKEN_KEY = "botToken";
    private final Logger logger = LoggerFactory.getLogger(BotConfigUtil.class);
    private final Properties botProperties = loadProperties();

    public static String getBotUsername() {
        return botProperties.getProperty(BOT_USERNAME_KEY);
    }

    public static String getBotToken() {
        return botProperties.getProperty(BOT_TOKEN_KEY);
    }

    private static Properties loadProperties() {
        try (InputStream input = BotConfigUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)) {
            Properties properties = new Properties();
            if (input != null) {
                properties.load(input);
            } else {
                String errorMessage = String.format("Properties file %s not found", PROPERTIES_FILE_NAME);
                logger.error(errorMessage);
                throw new PropertiesParsingException(errorMessage);
            }
            return properties;
        } catch (IOException e) {
            String errorMessage = String.format("Error loading properties from %s file", PROPERTIES_FILE_NAME);
            logger.error(errorMessage);
            throw new PropertiesParsingException(errorMessage, e);
        }
    }
}