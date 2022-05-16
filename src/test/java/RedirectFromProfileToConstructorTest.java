import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RedirectFromProfileToConstructorTest {

    String name;
    String email;
    String password;
    MainPage mainPage;

    @Before
    public void setUp() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();

        mainPage = open(MainPage.URL, MainPage.class)
                .createUserAndLogin(name, email, password);
    }

    @After
    public void tearDawn() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Redirect from Profile to MainPage by Constructor button")
    public void redirectFromProfileByConstructButtonIsCorrectTest() {
        boolean isBurgerConstructorHeaderExist = mainPage.clickProfileButtonAfterAuth()
                .clickConstructorButton()
                .isBurgerConstructorHeaderExist();

        assertEquals("Redirect is not correct", true, isBurgerConstructorHeaderExist);

    }

    @Test
    @DisplayName("Redirect from Profile to MainPage by Logo button")
    public void redirectFromProfileByLogoButtonIsCorrectTest() {
        boolean isBurgerConstructorHeaderExist = mainPage.clickProfileButtonAfterAuth()
                .clickLogoButton()
                .isBurgerConstructorHeaderExist();

        assertEquals("Redirect is not correct", true, isBurgerConstructorHeaderExist);
    }

}
