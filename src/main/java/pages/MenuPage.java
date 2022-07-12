package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import util.ScrollHelper;

import java.time.Duration;


public class MenuPage {

    private static final String firstUser = "(//android.widget.CheckBox[@content-desc=\"users\"][1])";
    private static final String allUsers = "(//android.widget.CheckBox[@content-desc=\"users\"])";
    private static final String backButton = "//android.widget.Button[@content-desc=\"Back\"]";
    private static final String userInfo = "//android.view.View[contains(@content-desc, \"USER ID\")]";
    private static final String userInfoById = "//android.view.View[contains(@content-desc, \"USER ID: %d\")]";

    public static String getAboutLastUserById(int id) {
        Selenide.$x(firstUser).shouldBe(Condition.visible);
        Selenide.$$x(allUsers).get(6).click();
        Selenide.$x(backButton).shouldBe(Condition.visible, Duration.ofMillis(2000));
        if (Selenide.$x(String.format(userInfoById, id)).is(Condition.not(Condition.visible))) {
            Selenide.$x(backButton).shouldBe(Condition.visible, Duration.ofMillis(800)).click();
            Selenide.$x(firstUser).shouldBe(Condition.visible);
            ScrollHelper.swipeScreen(ScrollHelper.Direction.UP);
            return getAboutLastUserById(id);
        } else return Selenide.$x(String.format(userInfoById, id)).getDomAttribute("content-desc");
    }

    public static String getAboutUserById(int id) {
        Selenide.$x(firstUser).shouldBe(Condition.visible).click();
        Selenide.$x(userInfo).shouldBe(Condition.visible, Duration.ofMillis(2000));
        if (Selenide.$x(String.format(userInfoById, id)).is(Condition.not(Condition.visible))) {
            Selenide.$x(backButton).shouldBe(Condition.visible, Duration.ofMillis(800)).click();

            Selenide.$x(firstUser).shouldBe(Condition.visible);
            Selenide.$$x(allUsers).get(1).click();
            Selenide.$x(userInfo).shouldBe(Condition.visible, Duration.ofMillis(2000));
            if (Selenide.$x(String.format(userInfoById, id)).is(Condition.not(Condition.visible))) {
                Selenide.$x(backButton).shouldBe(Condition.visible, Duration.ofMillis(800)).click();
                Selenide.$x(firstUser).shouldBe(Condition.visible);
            } else return Selenide.$x(String.format(userInfoById, id)).getDomAttribute("content-desc");

            Selenide.$x(firstUser).shouldBe(Condition.visible);
            Selenide.$$x(allUsers).get(2).click();
            Selenide.$x(userInfo).shouldBe(Condition.visible, Duration.ofMillis(2000));
            if (Selenide.$x(String.format(userInfoById, id)).is(Condition.not(Condition.visible))) {
                Selenide.$x(backButton).shouldBe(Condition.visible, Duration.ofMillis(800)).click();
                Selenide.$x(firstUser).shouldBe(Condition.visible);
            } else return Selenide.$x(String.format(userInfoById, id)).getDomAttribute("content-desc");
            ScrollHelper.swipeScreen(ScrollHelper.Direction.UP, 10_000);
            return getAboutUserById(id);
        } else return Selenide.$x(String.format(userInfoById, id)).getDomAttribute("content-desc");
    }

}
