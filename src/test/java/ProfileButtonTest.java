import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class ProfileButtonTest {

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
    @DisplayName("Click Profile button after auth")
    public void clickProfileButtonIsCorrectTest() {

        boolean isProfileHeaderExist = open(LoginPage.URL, LoginPage.class)
                .loginUser(email, password)
                .clickProfileButtonAfterAuth()
                .isProfileHeaderExist();

        assertEquals("profile header not exist", true, isProfileHeaderExist);

    }
}
