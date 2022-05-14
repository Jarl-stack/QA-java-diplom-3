import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private SelenideElement recoveryPasswordAuthButton = $(By.xpath("//a[contains(text(),'Войти')]"));

    @Step("click auth button from Recovery Password page")
    public LoginPage clickRecoveryPasswordAuthButton() {
        recoveryPasswordAuthButton.click();
        return page(LoginPage.class);

    }

}
