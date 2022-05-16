import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;


public class RegistrationTest {

    @After
    public void tearDawn() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Registration new user with valid data")
    public void userCanRegisterWithValidDataTest() {

        Faker faker = new Faker();

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .typeName(name)
                .typeEmail(email)
                .typePassword(password)
                .clickConfirmRegistrationButtonAndProceed()
                .waitForAuthButton();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals("user wasn't register", "https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

}
