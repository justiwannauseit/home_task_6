package config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AppiumConfig {

    private static final String configPath = "src/main/resources/appiumCustom.properties";

    public static final String BASE_URL = getProperty("base.url");

    public static final String DEVICE_NAME = getProperty("device.name");
    public static final String PLATFORM_VERSION = getProperty("platform.version");
    public static final String AUTOMATION_NAME = getProperty("automation.framework.name");
    public static final boolean AUTO_GRANT_PERMISSION = Boolean.parseBoolean(getProperty("auto.grant.permission"));

    public static final String APP_NAME = getProperty("app.name");

    private static String getProperty(final String param) {
        return PropertyListenerUtil.getPropertyFromFile(configPath, param);
    }

}
