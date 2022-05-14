import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    private SelenideElement loginButton = $(By.xpath("//button[contains(text(),'Войти в аккаунт')]"));

    private SelenideElement createOrderButton = $(By.xpath("//button[contains(text(),'Оформить заказ')]"));

    private SelenideElement profileButton = $(By.xpath("//p[contains(text(),'Личный Кабинет')]"));

    private SelenideElement burgerConstructionHeader = $(By.xpath("//h1[contains(text(),'Соберите бургер')]"));

    private SelenideElement bunsButton = $(By.xpath("//span[contains(text(),'Булки')]"));

    private SelenideElement saucesButton = $(By.xpath("//span[contains(text(),'Соусы')]"));

    private SelenideElement ingredientsButton = $(By.xpath("//span[contains(text(),'Начинки')]"));

    private SelenideElement bunsHeader = $(By.xpath("//h2[contains(text(),'Булки')]"));

    private SelenideElement saucesHeader = $(By.xpath("//h2[contains(text(),'Соусы')]"));

    private SelenideElement ingredientsHeader = $(By.xpath("//h2[contains(text(),'Начинки')]"));

    private SelenideElement constructorContainer = $(By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']"));

    @Step("click Login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Register new random user")
    public void createUser(String name, String email, String password) {

        open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .typeName(name)
                .typeEmail(email)
                .typePassword(password)
                .clickConfirmRegistrationButton();
    }

    @Step("check order button")
    public boolean isCreateOrderButtonAppear() {
        createOrderButton.shouldBe(Condition.visible);
        return createOrderButton.exists();
    }

    @Step("click Profile button before auth")
    public LoginPage clickProfileButtonWithoutAuth() {
        profileButton.click();
        return page(LoginPage.class);
    }

    @Step("click Profile button after auth")
    public ProfilePage clickProfileButtonAfterAuth() {
        profileButton.click();
        return page(ProfilePage.class);
    }

    @Step("create new random user and login by him")
    public MainPage createUserAndLogin(String name, String email, String password) {

        return open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegistrationButton()
                .typeName(name)
                .typeEmail(email)
                .typePassword(password)
                .clickConfirmRegistrationButtonAndProceed()
                .enterHeaderShouldBeVisible()
                .typeEmail(email)
                .typePassword(password)
                .clickLoginPageAuthButton();
    }

    @Step("check burger Constructor header")
    public boolean isBurgerConstructorHeaderExist() {
        return burgerConstructionHeader.exists();
    }

    @Step("Click buns button in constructor container")
    public MainPage clickBunsButton() {
        bunsButton.click();
        return this;
    }

    @Step("Click sauces button in constructor container")
    public MainPage clickSaucesButton() {
        saucesButton.click();
        return this;
    }

    @Step("Click ingredients button in constructor container")
    public MainPage clickIngredientsButton() {
        ingredientsButton.click();
        return this;
    }

    @Step("check buns header is appear")
    public boolean isBunsHeaderIsDisplayed() {
        return bunsHeader.isDisplayed();
    }

    @Step("check sauces header is appear")
    public boolean isSaucesHeaderIsDisplayed() {
        return saucesHeader.isDisplayed();
    }

    @Step("check ingredients header is appear")
    public boolean isIngredientsHeaderIsDisplayed() {
        return ingredientsHeader.isDisplayed();
    }

    @Step("scroll to buns header")
    public MainPage scrollToBunsHeader() {
        constructorContainer.click();
        bunsHeader.scrollTo();
        return this;
    }

    @Step("scroll to sauces header")
    public MainPage scrollToSaucesHeader() {
        constructorContainer.click();
        saucesHeader.scrollTo();
        return this;
    }

    @Step("scroll to ingredients header")
    public MainPage scrollToIngredientsHeader() {
        constructorContainer.click();
        ingredientsHeader.scrollTo();
        return this;
    }

    @Step("wait until constructor container become visible")
    public MainPage constructionContainerShouldBeVisible() {
        constructorContainer.shouldBe(Condition.visible);
        return this;
    }

}
