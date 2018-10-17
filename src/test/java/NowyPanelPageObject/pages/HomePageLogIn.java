package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


//open firs page and log in

public class HomePageLogIn extends BasePage {

    public HomePageLogIn() {
        super();
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(name = "login-button")
    private WebElement zaloguj;

    @FindBy(xpath = "//h3")
    private WebElement homePageTitle;


    public HomePageLogIn verifyHomePage(String tytulStronyLogowania) {
        Assertions.assertEquals(tytulStronyLogowania, homePageTitle.getText());
        return this;
    }

    @Step
    public NewOrderPage openNewOrderPage(String uzytkownik, String haslo) {
        username.sendKeys(uzytkownik);
        password.sendKeys(haslo);
        zaloguj.click();
        return new NewOrderPage();
    }
}
