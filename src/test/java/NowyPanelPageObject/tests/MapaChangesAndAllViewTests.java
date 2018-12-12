package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.junit.jupiter.api.Assertions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class MapaChangesAndAllViewTests extends TestConfig {

    @org.testng.annotations.Test
    public void selectAndUnselectCheckboxes() throws InterruptedException {
        new MakeOrderPage()
                .selectAutomatyczneOdswiezanieListyCheckbox()
                .unselectAutomaczneDopasowywanieWidoku();
    }

    @org.testng.annotations.Test
    public void compareImageOfMakeOrderPage () throws Exception {
        File image = new File("C:\\Users\\user\\Documents\\TestyScreeny\\MakeOrderPageScreen.png");
        BufferedImage expectedImage = ImageIO.read(image);
        boolean status = Shutterbug.shootPage(getInstance(),ScrollStrategy.BOTH_DIRECTIONS,500,true).withName("Actual").equals(expectedImage,0.1);
        Assertions.assertTrue(status);
    }




}
