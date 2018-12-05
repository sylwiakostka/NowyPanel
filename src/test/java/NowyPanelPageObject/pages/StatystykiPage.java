package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class StatystykiPage extends BasePage {
    public StatystykiPage() {
        super();
    }

    @FindBy(xpath = "//em[.='zakończone']")
    private WebElement tekstWyjasniajacy;

    public StatystykiPage verifyStatystyiPage() {
        for (String winHandle : getInstance().getWindowHandles()) {
            getInstance().switchTo().window(winHandle);
        }
        Assertions.assertTrue(tekstWyjasniajacy.isDisplayed());
        return this;
    }
}

