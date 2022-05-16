import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";


    private SelenideElement registrationButton = $(By.xpath("//a[contains(text(),'Зарегистрироваться')]"));

    private SelenideElement authorizationButton = $(By.xpath("//button[contains(text(),'Войти')]"));

    private SelenideElement emailField = $(By.xpath("//label[contains(text(),'Email')]/following-sibling::input"));

    private SelenideElement passwordField = $(By.xpath("//label[contains(text(),'Пароль')]/following-sibling::input"));

    private SelenideElement enterHeader = $(By.xpath("//h2[contains(text(),'Вход')]"));

    @Step("New Test method for rename")
    public MainPage clickAuthButtonTestMethod() {
        authorizationButton.click();
        return page(MainPage.class);
    }


    @Step("Wait until Auth button is appear")
    public void waitForAuthButton() {
        authorizationButton.shouldBe(Condition.visible);
    }

    @Step("Click registration button")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Wait until Enter header is appear")
    public LoginPage enterHeaderShouldBeVisible() {
        enterHeader.shouldBe(Condition.visible);
        authorizationButton.shouldBe(Condition.enabled);
        return this;
    }

    @Step("Type email in field")
    public LoginPage typeEmail(String email) {
        emailField.click();
        emailField.val(email);
        return this;
    }

    @Step("Type password in field")
    public LoginPage typePassword(String password) {
        passwordField.click();
        passwordField.val(password);
        return this;
    }

    @Step("Click auth button from Login page")
    public MainPage clickLoginPageAuthButton() {
       // sleep(500);
        authorizationButton.shouldBe(Condition.enabled).click();
        return page(MainPage.class);
    }

    @Step("Login user")
    public MainPage loginUser(String email, String password) {
        typeEmail(email);
        typePassword(password);
        return clickLoginPageAuthButton();
    }

    @Step("check enter header on page")
    public boolean isHeaderShouldBeExist() {
        enterHeader.shouldBe(Condition.visible);
        return enterHeader.exists();
    }

}
