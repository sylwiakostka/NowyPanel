package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class RaportyPage extends BasePage {
    public RaportyPage() {
        super();
    }

    @FindBy(id = "report-type-dropdown")
    private WebElement raportPorzuconychZlecen;

    public RaportyPage verifyRaportyPage() {
        for (String winHandle : getInstance().getWindowHandles()) {
            getInstance().switchTo().window(winHandle);
        }
        Assertions.assertTrue(raportPorzuconychZlecen.isDisplayed());
        return this;
    }

}
