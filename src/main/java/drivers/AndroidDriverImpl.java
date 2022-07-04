package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class AndroidDriverImpl implements WebDriverProvider {

  @Nonnull
  @Override
  @SneakyThrows
  public WebDriver createDriver(@Nonnull org.openqa.selenium.Capabilities capabilities) {
    return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities.getAppiumCapabilities());
  }

}
