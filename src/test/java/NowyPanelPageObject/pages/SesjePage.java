package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class SesjePage extends BasePage {
    public SesjePage() {
        super();
    }

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement labelOdswiezanie;

    public SesjePage verifySesjePage() {
        for (String winHandle : getInstance().getWindowHandles()) {
            getInstance().switchTo().window(winHandle);
        }
        Assertions.assertTrue(labelOdswiezanie.isDisplayed());
        return this;
    }


}
