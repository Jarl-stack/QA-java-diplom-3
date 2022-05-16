import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    private SelenideElement nameField = $(By.xpath("//label[contains(text(),'Имя')]/following-sibling::input"));

    private SelenideElement emailField = $(By.xpath("//label[contains(text(),'Email')]/following-sibling::input"));

    private SelenideElement passwordField = $(By.xpath("//label[contains(text(),'Пароль')]/following-sibling::input"));

    private SelenideElement confirmRegistrationButton = $(By.xpath("//button[contains(text(),'Зарегистрироваться')]"));

    private SelenideElement errorPasswordMessage = $(By.xpath("//p[contains(text(),'Некорректный пароль')]"));

    private SelenideElement registrationPageAuthButton = $(By.xpath("//a[contains(text(),'Войти')]"));

    @Step("type user name in field")
    public RegistrationPage typeName(String name) {
        nameField.val(name);
        return this;
    }

    @Step("type user email in field")
    public RegistrationPage typeEmail(String email) {
        emailField.val(email);
        return this;
    }

    @Step("type user password in field")
    public RegistrationPage typePassword(String password) {
        passwordField.val(password);
        return this;
    }

    @Step("Click Registration button")
    public RegistrationPage clickConfirmRegistrationButton() {
        confirmRegistrationButton.click();
        return this;
    }

    @Step("Click Registration button and redirect to Login Page")
    public LoginPage clickConfirmRegistrationButtonAndProceed() {
        confirmRegistrationButton.click();
        return page(LoginPage.class);
    }

    @Step("check error message is appear")
    public boolean isErrorMessageAppear() {
        return errorPasswordMessage.exists();
    }

    @Step("Click auth button")
    public LoginPage clickRegistrationPageAuthButton() {
        registrationPageAuthButton.click();
        return page(LoginPage.class);
    }

}
