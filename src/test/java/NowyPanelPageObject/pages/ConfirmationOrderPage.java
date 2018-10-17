package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationOrderPage extends BasePage {
    public ConfirmationOrderPage() {
        super();
    }

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement affirmationAlert;


    public ConfirmationOrderPage verifyConfirmationPage(String alertPotwierdzajacy) {
        Assertions.assertEquals(alertPotwierdzajacy, affirmationAlert.getText());
        return this;
    }

}

