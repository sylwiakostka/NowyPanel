package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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


    public NewOrderPage verifyNewOrderPage(String tytulStronyNoweZlecenie) {
        Assertions.assertEquals(tytulStronyNoweZlecenie, newOrderPageTitle.getText());
        return this;
    }

    public MakeOrderPage openMakeOrderPage(String phoneNumber) {
        phoneField.sendKeys(phoneNumber);
        submitButton.click();

        return new MakeOrderPage();
    }

}
