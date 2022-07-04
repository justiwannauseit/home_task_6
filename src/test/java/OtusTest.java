import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.AndroidDriverImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MenuPage;

import java.util.Random;

public class OtusTest {

  @BeforeEach
  public void init() {
    Configuration.browserSize = null;
    Configuration.browser = AndroidDriverImpl.class.getName();
    Selenide.open();
  }

  @AfterEach
  public void close() {
    Selenide.closeWebDriver();
  }

  @Test
  public void check_all_users_is_100() {
    String value = MenuPage.getAboutLastUserById(99);
    Assertions.assertTrue(value.contains("USER ID: 99"));
    Assertions.assertTrue(value.contains("USER NAME: name"));
    Assertions.assertTrue(value.contains("USER GRADE: grade"));
    Assertions.assertTrue(value.contains("USER CITY: City"));
    Assertions.assertTrue(value.contains("USER SCHOOL NAME: Some school"));
  }

  @Test
  public void check_random_user() {
    int random = new Random().nextInt(4) + 1; //можно и больше, но тест будет идти дольше
    String value = MenuPage.getAboutUserById(random);
    Assertions.assertTrue(value.contains("USER ID: " + random));
  }

}
