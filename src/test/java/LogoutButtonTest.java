import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class LogoutButtonTest {

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
    @DisplayName("Logout from Profile page by clicking Logout button")
    public void logoutFromProfileByClickingLogoutButton() {

        boolean isEnterHeaderExist = mainPage.clickProfileButtonAfterAuth()
                .clickExitButton()
                .isHeaderShouldBeExist();

        assertEquals("logout from profile do not work", true, isEnterHeaderExist);
    }
}