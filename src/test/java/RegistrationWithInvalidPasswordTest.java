import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegistrationWithInvalidPasswordTest {

    String password;
    boolean isErrorMessageAppearExpected;

    public RegistrationWithInvalidPasswordTest(String password, boolean isErrorMessageAppearExpected) {
        this.password = password;
        this.isErrorMessageAppearExpected = isErrorMessageAppearExpected;
    }

    @Parameterized.Parameters(name = "Test data: {0} {1} {2} {3} {4}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"", false},
                {"q", true},
                {"rty", true},
                {"rTy6", true},
                {"1ty6T", true}
        };
    }

    @Test
    @DisplayName("Parametrized password negative test")
    public void errorMessageWithInvalidPasswordIsAppearTest() {

        boolean isErrorMessageAppearActual = open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .typePassword(password)
                .clickConfirmRegistrationButton()
                .clickConfirmRegistrationButton()
                .isErrorMessageAppear();

        assertEquals("error message not appear", isErrorMessageAppearExpected, isErrorMessageAppearActual);
    }


}
