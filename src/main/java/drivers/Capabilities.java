package drivers;

import config.AppiumConfig;
import io.appium.java_client.remote.MobileCapabilityType;
import io.netty.util.internal.ResourcesUtil;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Capabilities {

    public static DesiredCapabilities getAppiumCapabilities() {
        File app = ResourcesUtil.getFile(Capabilities.class, AppiumConfig.APP_NAME);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AppiumConfig.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, AppiumConfig.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AppiumConfig.AUTOMATION_NAME);
        capabilities.setCapability("autoGrantPermission", AppiumConfig.AUTO_GRANT_PERMISSION);
        return capabilities;
    }

}
