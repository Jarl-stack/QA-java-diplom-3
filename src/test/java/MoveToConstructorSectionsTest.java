import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class MoveToConstructorSectionsTest {

    @Test
    @DisplayName("Move to Buns in Constructor by clicking button")
    public void moveToBunsSectionByButtonIsCorrectTest() {
        boolean isBunsHeaderIsDisplayed = open(MainPage.URL, MainPage.class)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed();

        assertEquals("move to buns by button isn't correct", true, isBunsHeaderIsDisplayed);
    }

    @Test
    @DisplayName("Move to Sauces in Constructor by clicking button")
    public void moveToSaucesSectionByButtonIsCorrectTest() {

        boolean isSaucesHeaderIsDisplayed = open(MainPage.URL, MainPage.class)
                .clickSaucesButton()
                .isSaucesHeaderIsDisplayed();

        assertEquals("move to sauces by button isn't correct", true, isSaucesHeaderIsDisplayed);
    }

    @Test
    @DisplayName("Move to Ingredients in Constructor by clicking button")
    public void moveToIngredientsSectionByButtonIsCorrect() {

        boolean isIngredientsHeaderIsDisplayed = open(MainPage.URL, MainPage.class)
                .clickIngredientsButton()
                .isIngredientsHeaderIsDisplayed();

        assertEquals("move to ingredients by button isn't correct", true, isIngredientsHeaderIsDisplayed);
    }

    @Test
    @DisplayName("Move to Buns in Constructor by scrolling")
    public void moveToBunsSectionByScrollIsCorrect() {

        boolean isIngredientsHeaderIsDisplayed = open(MainPage.URL, MainPage.class)
                .scrollToIngredientsHeader()
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed();

        assertEquals("move to ingredients by button isn't correct", true, isIngredientsHeaderIsDisplayed);
    }


    @Test
    @DisplayName("Move to Sauces in Constructor by scrolling")
    public void moveToSaucesSectionByScrollIsCorrect() {

        boolean isIngredientsHeaderIsDisplayed = open(MainPage.URL, MainPage.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderIsDisplayed();

        assertEquals("move to ingredients by button isn't correct", true, isIngredientsHeaderIsDisplayed);
    }


    @Test
    @DisplayName("Move to Ingredients in Constructor by scrolling")
    public void moveToIngredientsSectionByScrollIsCorrect() {

        boolean isIngredientsHeaderIsDisplayed = open(MainPage.URL, MainPage.class)
                .scrollToIngredientsHeader()
                .isIngredientsHeaderIsDisplayed();

        assertEquals("move to ingredients by button isn't correct", true, isIngredientsHeaderIsDisplayed);
    }

}