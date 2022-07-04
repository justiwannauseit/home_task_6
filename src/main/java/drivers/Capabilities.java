package drivers;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URISyntaxException;

public class Capabilities {

    public static DesiredCapabilities getAppiumCapabilities() throws URISyntaxException {
        File app = new File("src/main/resources/app/app_debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "APPIUM");
        capabilities.setCapability("autoGrantPermission", true);
        return capabilities;
    }

}
