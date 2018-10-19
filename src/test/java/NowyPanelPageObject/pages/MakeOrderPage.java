package NowyPanelPageObject.pages;

import NowyPanelPageObject.utilities.DataFaker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.FileInputStream;
import java.io.IOException;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;
import static NowyPanelPageObject.utilities.Utilities.waitForElementToBeClickable;
import static NowyPanelPageObject.utilities.Utilities.waitForVisibilityOfElement;

public class MakeOrderPage extends BasePage {

    public MakeOrderPage() {
        super();
    }

    private DataFaker faker = new DataFaker();
    private Actions builder = new Actions(getInstance());
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @FindBy(xpath = "//a[@ng-click='c.driver()']")
    private WebElement platnoscUKierowcyButton;

    @FindBy(xpath = "//div[@class='col-md-4 col-voucher']/a[@class='center-block btn btn-default']")
    private WebElement voucherButton;


    @FindBy(xpath = "//a[@class='center-block btn btn-primary']")
    private WebElement profilBiznesowyButton;

    @FindBy(id = "address-from")
    private WebElement adresStartuField;

    @FindBy(xpath = "//input[@id='address-to']")
    private WebElement adresDocelowyField;

    @FindBy(id = "model-date")
    private WebElement date;

    @FindBy(xpath = "//td[@class='uib-increment hours']")
    private WebElement hourButtonPlus;

    @FindBy(xpath = "//td[@class='uib-decrement hours']")
    private WebElement hourButtonMinus;

    @FindBy(xpath = "//td[@class='uib-increment minutes']")
    private WebElement minuteButtonPlus;

    @FindBy(xpath = "//td[@class='uib-decrement hours']")
    private WebElement minuteButtonMinus;

    @FindBy(id = "client-name")
    private WebElement imieINazwiskoFieldB2C;

    @FindBy(xpath = "//div[@class='row order-form-section order-form-client ng-scope']")
    private WebElement imieINaziwskoFieldB2B;

    @FindBy(xpath = "//*[@id=\"tariffs\"]/div[1]/div[1]/i")
    private WebElement sliderLeft;

    @FindBy(xpath = "//*[@id=\"tariffs\"]/div[1]/div[2]/i")
    private WebElement sliderRight;

    @FindBy(id = "number-of-cars-dropdown")
    private WebElement liczbaTaksowekButton;

    @FindBy(partialLinkText = "2")
    private WebElement wybranaIlosc2;

    @FindBy(partialLinkText = "3")
    private WebElement wybranaIlosc3;

    @FindBy(partialLinkText = "4")
    private WebElement wybranaIlosc4;

    @FindBy(partialLinkText = "5")
    private WebElement wybranaIlosc5;

    @FindBy(partialLinkText = "6")
    private WebElement wybranaIlosc6;

    @FindBy(partialLinkText = "7")
    private WebElement wybranaIlosc7;

    @FindBy(partialLinkText = "8")
    private WebElement wybranaIlosc8;

    @FindBy(id = "car-class-dropdown")
    private WebElement klasaButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='popularna']")
    private WebElement listaKlasaPopularna;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='luksusowa']")
    private WebElement listaKlasaLuksusowa;

    @FindBy(xpath = "//a[@class='btn btn-block ng-binding btn-default']")
    private WebElement filtryButton;

    @FindBy(id = "model-comment")
    private WebElement komentarz;

    @FindBy(id = "model-note")
    private WebElement notatka;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-block']")
    private WebElement zapiszButton;

    @FindBy(xpath = "//a[@class='btn btn-default btn-block']")
    private WebElement odrzucButton;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.animals.enabled']")
    private WebElement zwierzetaCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.langEn.enabled']")
    private WebElement englishCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.childSeat.enabled']")
    private WebElement fotelikCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.startingCables.enabled']")
    private WebElement kableCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.estate.enabled']")
    private WebElement kombiCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.cardPayment.enabled']")
    private WebElement platnoscKartaCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.shipping.enabled']")
    private WebElement przesylkaCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.shopping.enabled']")
    private WebElement zakupyCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.airConditioning.enabled']")
    private WebElement klimatyzacjaCheckbox;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input[@ng-model='filters.bus.enabled']")
    private WebElement busCheckbox;

    @FindBy(xpath = "//select")
    private WebElement liczbaPasazerowSelect;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement zastosujZmianyButton;

    @FindBy(xpath = "//button[@class='btn btn-default pull-left']")
    private WebElement porzucZmianyButton;

    @FindBy(xpath = "//a[@class='btn btn-default ng-binding ng-scope']")
    private WebElement wybraneFiltry;

    @FindBy(xpath = "//div[@class='row order-form-section order-form-phones']/h6[@class='section-name']")
    private WebElement makeOrderPageTitle;

    @FindBy(partialLinkText = "2")
    private WebElement dwieTaksowki;

    @FindBy(partialLinkText = "3")
    private WebElement trzyTaksowki;

    @FindBy(xpath = "//div[@style='text-align:right;padding-top:14px;white-space:nowrap;']")
    private WebElement stawkaZaKmLeft;

    @FindBy(xpath = "//div[@style='text-align:left;padding-top:14px;white-space:nowrap;']")
    private WebElement stawkaZaKmRight;

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement oknoFiltry;

    @FindBy(xpath = "//div[@class = 'modal-content']")
    private WebElement oknoPowoduOdrzucenia;

    @FindBy(id = "reasons-dropdown")
    private WebElement listaPowodowOdrzucenia;

    @FindBy(xpath = "//button[@class= 'btn btn-primary']")
    private WebElement zapiszOdrzucenieButton;

    @FindBy(partialLinkText = "Reklamacja")
    private WebElement powodOdrzuceniaReklamacja;

    @FindBy(xpath = "//div[@uib-modal-transclude]//input [@ng-model='c.code']")
    private WebElement numerVouchera;

    @FindBy(xpath = "//div[@uib-modal-transclude]//a[@class='center-block btn btn-primary']")
    private WebElement sprawdzButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement voucherAlertError;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement voucherAlertAvailable;

    @FindBy(xpath = "//div[@class = 'col-lg-6']//button[@class='btn btn-primary']")
    private WebElement zastosujVoucherButton;

    @FindBy(xpath = "//button[@class='btn btn-default pull-left']")
    private WebElement zamknijErrorVoucherButton;

    @FindBy(xpath = "//div[@class='input-group']//input[@ng-model='model.voucher.code']")
    private WebElement voucherNumberField;

    @FindBy (xpath = "//div[@class='input-group']//input [@ng-model='model.values.client.name']")
    private WebElement danePracownika;

    @FindBy (xpath = "//ul [@class='dropdown-menu ng-isolate-scope']//a [@tabindex = '-1']")
    private WebElement listaPracownik;


    @Step
    public MakeOrderPage verifyMakeOrderPage(String tytulStronyZamowienia) {
        Assertions.assertEquals(tytulStronyZamowienia, makeOrderPageTitle.getText());
        return this;
    }

    @Step
    public MakeOrderPage choseB2COrder() throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibilityOfElement(platnoscUKierowcyButton);
        platnoscUKierowcyButton.click();
        return this;
    }

    @Step
    public MakeOrderPage introduceAddressesAndFullName(String adresStartu, String adresDocelowy) throws InterruptedException {
        Thread.sleep(1000);
        adresStartuField.sendKeys(adresStartu);
        WebElement wskazanyAdresStartu = getInstance().findElement(By.partialLinkText(adresStartu));
        waitForVisibilityOfElement(wskazanyAdresStartu);
        wskazanyAdresStartu.click();
        Thread.sleep(1000);
        adresDocelowyField.sendKeys(adresDocelowy);
        WebElement wskazanyAdresDocelowy = getInstance().findElement(By.partialLinkText(adresDocelowy));
        wskazanyAdresDocelowy.click();
        Thread.sleep(1000);
        imieINazwiskoFieldB2C.sendKeys(faker.getFakeName());
        Thread.sleep(1000);
        return this;
    }

    @Step
    public MakeOrderPage introduceAddresses(String adresStartu, String adresDocelowy) throws InterruptedException {
        Thread.sleep(1000);
        adresStartuField.sendKeys(adresStartu);
        WebElement wskazanyAdresStartu = getInstance().findElement(By.partialLinkText(adresStartu));
        waitForVisibilityOfElement(wskazanyAdresStartu);
        wskazanyAdresStartu.click();
        Thread.sleep(1000);
        adresDocelowyField.sendKeys(adresDocelowy);
        WebElement wskazanyAdresDocelowy = getInstance().findElement(By.partialLinkText(adresDocelowy));
        wskazanyAdresDocelowy.click();
        return this;
    }


    @Step
    public ConfirmationOrderPage saveOrder() {
        zapiszButton.click();
        return new ConfirmationOrderPage().verifyConfirmationPage("Obsługa zgłoszenie została zakończona. Możesz zamknąć okno przeglądarki.");
    }

    @Step
    public MakeOrderPage choseLuxuryTaxi() {
        klasaButton.click();
        listaKlasaLuksusowa.click();
        Assertions.assertEquals("Klasa: luksusowa", klasaButton.getText());
        return this;
    }

    @Step
    public MakeOrderPage chosePopularTaxi() {
        klasaButton.click();
        listaKlasaPopularna.click();
        Assertions.assertEquals("Klasa: popularna", klasaButton.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage orderTwoTaxis() {
        liczbaTaksowekButton.click();
        dwieTaksowki.click();
        Assertions.assertEquals("Liczba taksówek: 2", liczbaTaksowekButton.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage orderThreeTaxis() {
        liczbaTaksowekButton.click();
        trzyTaksowki.click();
        Assertions.assertEquals("Liczba taksówek: 3", liczbaTaksowekButton.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage dragAndDropeLeft(int x, int y, String leftFee) throws InterruptedException {
        builder.dragAndDropBy(sliderLeft, x, y).build().perform();
        Thread.sleep(3000);
        Assertions.assertEquals(leftFee, stawkaZaKmLeft.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage dragAndDropeRight(int x, int y, String rightFee) throws InterruptedException {
        builder.dragAndDropBy(sliderRight, x, y).build().perform();
        Thread.sleep(3000);
        Assertions.assertEquals(rightFee, stawkaZaKmRight.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage choosePayByCardFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(platnoscKartaCheckbox);
        waitForElementToBeClickable(platnoscKartaCheckbox);
        Thread.sleep(3000);
        platnoscKartaCheckbox.click();
        Thread.sleep(53000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Płatność kartą", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseZwierzetaFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(zwierzetaCheckbox);
        waitForElementToBeClickable(zwierzetaCheckbox);
        Thread.sleep(3000);
        zwierzetaCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Zwierzęta", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseKombiFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(kombiCheckbox);
        waitForElementToBeClickable(kombiCheckbox);
        Thread.sleep(3000);
        kombiCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Kombi", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseFotelikDlaDzieckaFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(fotelikCheckbox);
        waitForElementToBeClickable(fotelikCheckbox);
        Thread.sleep(3000);
        fotelikCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Fotelik dla dziecka", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseKlimatyzacjaFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(klimatyzacjaCheckbox);
        waitForElementToBeClickable(klimatyzacjaCheckbox);
        Thread.sleep(3000);
        klimatyzacjaCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Klimatyzacja", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage choosePrzesylkaFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(przesylkaCheckbox);
        waitForElementToBeClickable(przesylkaCheckbox);
        Thread.sleep(3000);
        przesylkaCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Przesyłka", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseZakupyFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(zakupyCheckbox);
        waitForElementToBeClickable(zakupyCheckbox);
        Thread.sleep(3000);
        zakupyCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Zakupy", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseJezykAngielskiFiltr() throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        waitForVisibilityOfElement(englishCheckbox);
        waitForElementToBeClickable(englishCheckbox);
        Thread.sleep(3000);
        englishCheckbox.click();
        Thread.sleep(3000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Język angielski", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage chooseBusFiltr(int iloscOsob) throws InterruptedException {
        filtryButton.click();
        waitForVisibilityOfElement(oknoFiltry);
        Thread.sleep(3000);
        busCheckbox.click();
        new Select(getInstance().findElement(By.xpath("//select"))).selectByIndex(iloscOsob);
        Thread.sleep(2000);
        zastosujZmianyButton.click();
        Assertions.assertEquals("Bus", wybraneFiltry.getText());
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage addComment(String komentarzText) {
        komentarz.sendKeys(komentarzText);
        return new MakeOrderPage();
    }

    @Step
    public MakeOrderPage addNote(String noteText) {
        notatka.sendKeys(noteText);
        return new MakeOrderPage();
    }

    @Step
    public ConfirmationOrderPage cancelOrder() throws InterruptedException {
        odrzucButton.click();
        Thread.sleep(2000);
        waitForVisibilityOfElement(oknoPowoduOdrzucenia);
        listaPowodowOdrzucenia.click();
        waitForVisibilityOfElement(powodOdrzuceniaReklamacja);
        powodOdrzuceniaReklamacja.click();
        zapiszOdrzucenieButton.click();
        return new ConfirmationOrderPage().verifyConfirmationPage("Obsługa zgłoszenie została zakończona. Możesz zamknąć okno przeglądarki.");
    }

    @Step
    public MakeOrderPage chooseCorrectVoucher(int indeksWiersz, int indeksKolumna) throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(voucherButton);
        voucherButton.click();
        numerVouchera.sendKeys(wyborKomorkiVoucher(indeksWiersz, indeksKolumna));
        sprawdzButton.click();
        Assertions.assertTrue(voucherAlertAvailable.isDisplayed());
        zastosujVoucherButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(voucherNumberField.isDisplayed());
        return this;
    }

    @Step
    public MakeOrderPage chooseIncorrectVoucher(int indeksWiersz, int indeksKolumna) throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(voucherButton);
        voucherButton.click();
        numerVouchera.sendKeys(wyborKomorkiVoucher(indeksWiersz, indeksKolumna));
        sprawdzButton.click();
        Assertions.assertTrue(voucherAlertError.isDisplayed());
        zamknijErrorVoucherButton.click();
        profilBiznesowyButton.isSelected();
        return this;
    }

    @Step
    public String wyborKomorkiVoucher(int indeksWiersz, int indeksKolumna) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\daneTesty.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("vouchery");
        Row row = sheet.getRow(indeksWiersz);
        Cell cell = row.getCell(indeksKolumna);
        return cell.getStringCellValue();
    }

    @Step
    public MakeOrderPage assertDanePracownika(int indeksWierszP, int indeksKolumnaP) throws Exception {
        String getValuePracownik = danePracownika.getAttribute("value");
        Assertions.assertEquals(getValuePracownik, wyborKomorkiVoucher(indeksWierszP, indeksKolumnaP));
        return this;
    }

    @Step
    public MakeOrderPage assertDaneVouchera(int indeksWierszV, int indeksKolumnaV) throws Exception {
        String getValueVoucher = voucherNumberField.getAttribute("value");
        Assertions.assertEquals(getValueVoucher, wyborKomorkiVoucher(indeksWierszV, indeksKolumnaV));
        return this;
    }

    @Step
    public MakeOrderPage chooseB2BOrder() throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(profilBiznesowyButton);
        profilBiznesowyButton.click();
        return this;
    }

    @Step
    public String wyborKomorkiPracownik(int indeksWiersz, int indeksKolumna) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\daneTesty.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("userB2B");
        Row row = sheet.getRow(indeksWiersz);
        Cell cell = row.getCell(indeksKolumna);
        return cell.getStringCellValue();
    }

    @Step
    public MakeOrderPage introduceDanePracownika (int indeksWiersz, int indeksKolumna ) throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(danePracownika);
        danePracownika.sendKeys(wyborKomorkiPracownik(indeksWiersz, indeksKolumna));
        listaPracownik.click();
        String getValueListaPracownik = danePracownika.getAttribute("value");
        Assertions.assertEquals(getValueListaPracownik,(wyborKomorkiPracownik(indeksWiersz, indeksKolumna)));
        return this;
    }
}










