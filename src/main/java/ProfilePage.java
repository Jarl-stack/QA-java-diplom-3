import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    private SelenideElement exitButton = $(By.xpath("//button[contains(text(),'Выход')]"));

    private SelenideElement profileHeader = $(By.xpath("//a[contains(text(),'Профиль')]"));

    private SelenideElement constructorButton = $(By.xpath("//p[contains(text(),'Конструктор')]"));

    private SelenideElement logoButton = $(By.xpath("//div[@class='AppHeader_header__logo__2D0X2']"));

    @Step("click Exit button")
    public LoginPage clickExitButton() {
        exitButton.click();
        return page(LoginPage.class);
    }

    @Step("check Profile header is exist")
    public boolean isProfileHeaderExist() {
        profileHeader.shouldBe(Condition.visible);
        return profileHeader.exists();
    }

    @Step("click Constructor button")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("click Logo button")
    public MainPage clickLogoButton() {
        logoButton.click();
        return page(MainPage.class);
    }

}
