package NowyPanelPageObject.pages;


//contains the common methods of all page classes

import org.openqa.selenium.support.PageFactory;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(getInstance(), this);
    }
}


