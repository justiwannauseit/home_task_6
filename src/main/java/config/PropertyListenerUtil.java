package config;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.util.Properties;

@UtilityClass
public class PropertyListenerUtil {

    @SneakyThrows
    public static String getPropertyFromFile(String path, String param) {
        Properties properties = new Properties();
        @Cleanup FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        fileInputStream.close();
        return properties.getProperty(param);
    }

}
