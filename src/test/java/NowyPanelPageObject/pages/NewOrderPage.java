package NowyPanelPageObject.pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;


//open page to introduce tel number

public class NewOrderPage extends BasePage {

    public NewOrderPage() {
        super();
    }

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h3")
    private WebElement newOrderPageTitle;

    @FindBy (xpath = "//form [@action]")
    private WebElement linkarea;


    public NewOrderPage verifyNewOrderPage(String tytulStronyNoweZlecenie) {
        Assertions.assertEquals(tytulStronyNoweZlecenie, newOrderPageTitle.getText());
        return this;
    }

    public MakeOrderPage openMakeOrderPage(String phoneNumber) {
        phoneField.sendKeys(phoneNumber);
        JavascriptExecutor js = (JavascriptExecutor) getInstance();
        js.executeScript("arguments[0].setAttribute('target', '_self');", linkarea);
        submitButton.click();
        return new MakeOrderPage();
    }

}
