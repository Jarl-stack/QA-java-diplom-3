import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class AuthorizationTest {

    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();

        MainPage mainPage = new MainPage();
        mainPage.createUser(name, email, password);
    }

    @After
    public void tearDawn() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Click Auth button from Main page")
    public void authButtonMainPageAuthIsSuccessTest() {

        boolean isCreateOrderButtonAppear = open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .typeEmail(email)
                .typePassword(password)
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();

        assertEquals("Create order button not appear", true, isCreateOrderButtonAppear);

    }

    @Test
    @DisplayName("Click Auth button from Profile page")
    public void authButtonProfileAuthIsSuccessTest() {

        boolean isCreateOrderButtonAppear = open(MainPage.URL, MainPage.class)
                .clickProfileButtonWithoutAuth()
                .typeEmail(email)
                .typePassword(password)
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();

        assertEquals("Create order button not appear", true, isCreateOrderButtonAppear);

    }

    @Test
    @DisplayName("Click Auth button from Registration page")
    public void authButtonRegistrationPageAuthIsSuccessTest() {

        boolean isCreateOrderButtonAppear = open(RegistrationPage.URL, RegistrationPage.class)
                .clickRegistrationPageAuthButton()
                .typeEmail(email)
                .typePassword(password)
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();

        assertEquals("Create order button not appear", true, isCreateOrderButtonAppear);
    }

    @Test
    @DisplayName("Click Auth button from Recovery password page")
    public void authButtonRecoveryPasswordPageAuthIsSuccess() {

        boolean isCreateOrderButtonAppear = open(RecoveryPasswordPage.URL, RecoveryPasswordPage.class)
                .clickRecoveryPasswordAuthButton()
                .typeEmail(email)
                .typePassword(password)
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();

        assertEquals("Create order button not appear", true, isCreateOrderButtonAppear);
    }

}
