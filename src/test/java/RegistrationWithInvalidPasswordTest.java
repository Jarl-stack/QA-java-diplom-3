import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegistrationWithInvalidPasswordTest {

    String password;

    public RegistrationWithInvalidPasswordTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters(name = "Test data: {0} {1} {2} {3} {4}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {""},
                {"q"},
                {"rty"},
                {"rTy6"},
                {"1ty6T"}
        };
    }

    @Test
    @DisplayName("Parametrized password negative test")
    public void errorMessageWithInvalidPasswordIsAppearTest() {

        boolean isErrorMessageAppear = open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .typePassword(password)
                .clickConfirmRegistrationButton()
                .clickConfirmRegistrationButton()
                .isErrorMessageAppear();

        assertEquals("error message not appear", true, isErrorMessageAppear);
    }


}
