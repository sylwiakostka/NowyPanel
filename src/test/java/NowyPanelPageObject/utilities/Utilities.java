package NowyPanelPageObject.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class Utilities {

    static final int WAIT_TIMEOUT = 10;
    private static WebDriverWait wait = new WebDriverWait(getInstance(), WAIT_TIMEOUT);

    public static void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable (WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}