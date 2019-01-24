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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;
import static NowyPanelPageObject.utilities.Utilities.waitForElementToBeClickable;
import static NowyPanelPageObject.utilities.Utilities.waitForVisibilityOfElement;

public class MakeOrderPage extends BasePage {

    public MakeOrderPage() {
        super();
    }

    private DataFaker faker = new DataFaker();
    private Actions builder = new Actions(getInstance());


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

    @FindBy(xpath = "//a[@ng-click='c.showModal()']")
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

    @FindBy(xpath = "//input [@ng-model='model.values.client.name']")
    private WebElement danePracownika;

    @FindBy(xpath = "//ul [@class='dropdown-menu ng-isolate-scope']//a [@tabindex = '-1']")
    private WebElement listaPracownik;

    @FindBy(xpath = "//input[@placeholder='HH']")
    private WebElement hourField;

    @FindBy(xpath = "//input[@placeholder='MM']")
    private WebElement minutesField;

    @FindBy(id = "model-date")
    private WebElement dataField;

    @FindBy(xpath = "//div/a [@href = 'https://itaxi.pl/taxi-corporation-client-web2/phoneHistory/list.html?phone=508264455&submit=Szukaj']")
    private WebElement historiaDzwoniacegoButton;

    @FindBy(xpath = "//a [@title = 'kliknij, aby przełączyć na wcześniejszą wersję panelu...']")
    private WebElement starszaWersjaPaneluButton;

    @FindBy(xpath = "//a[@title = 'kliknij, aby zgłosić problem...']")
    private WebElement zglosBladButton;

    @FindBy(xpath = "//textarea[@name = 'message']")
    private WebElement opiszProblemArea;

    @FindBy(xpath = "//button [@ng-if = '!saved']")
    private WebElement zglosButtonZgloszenieBledu;

    @FindBy(xpath = "//div [@class = 'alert alert-success ng-scope']")
    private WebElement alertPotwierdzenieZgloszeniaBledu;

    @FindBy(xpath = "//button [@ng-if = 'saved']")
    private WebElement zamknijButtonPotwierdzenieZgloszeniaBledu;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement narzedziaButton;

    @FindBy(xpath = "//li//a[@href='/admin/sessions']")
    private WebElement sesjeButton;

    @FindBy(xpath = "//li//a[@href='/admin/statistics']")
    private WebElement statystykiButton;

    @FindBy(xpath = "//li//a[@href='/admin/reports']")
    private WebElement raportyButton;

    @FindBy(xpath = "//li//a[@href='/admin/recently-dismissed-orders']")
    private WebElement monitoringOdrzuconychZlecenButton;

    @FindBy(xpath = "//div[@class='order-form-drivers-map']//input[@ng-model='state.autoupdate']")
    private WebElement automatyczneOdswiezanieListCheckbox;

    @FindBy(xpath = "//div[@class='order-form-drivers-map']//input[@ng-model='state.fitMapToMarkers']")
    private WebElement automatyczneDopasowanieWidokuCheckbox;

    @FindBy(xpath = "//button[@ng-click='model.clearVoucher()']")
    private WebElement usunVoucherButton;

    @FindBy(id = "model-date")
    private WebElement dateField;

    @FindBy(xpath = "//button [@class='btn btn-sm btn-success pull-right uib-close ng-binding']")
    private WebElement zamknijCalendarButton;

    @FindBy(xpath = "//p[@class='alert alert-danger ng-binding']")
    private WebElement alertDniTygodnia;

    @FindBy(xpath = "//p[@class = 'ng-binding']")
    private WebElement alertGodziny;

    @FindBy(xpath = "//p[@ng-show='c.voucher.maxTariff']")
    private WebElement alertMaxTaryfa;

    @FindBy(xpath = "//p[@ng-show='c.voucher.carClass']")
    private WebElement alertKlasaPopularna;

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
        Thread.sleep(2000);
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
    public MakeOrderPage chooseStaleVoucher(int indeksWiersz, int indeksKolumna) throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(voucherButton);
        voucherButton.click();
        numerVouchera.sendKeys(wyborKomorkiVoucher(indeksWiersz, indeksKolumna));
        sprawdzButton.click();
        String alertText = voucherAlertError.getText();
        Assertions.assertEquals("Voucher jest nieaktywny", alertText);
        zamknijErrorVoucherButton.click();
        profilBiznesowyButton.isSelected();
        return this;
    }


    @Step
    public MakeOrderPage deleteVoucher() throws Exception {
        usunVoucherButton.click();
        return new MakeOrderPage();
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
    public MakeOrderPage introduceDanePracownika(int indeksWiersz, int indeksKolumna) throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(danePracownika);
        danePracownika.sendKeys(wyborKomorkiPracownik(indeksWiersz, indeksKolumna));
        listaPracownik.click();
        String getValueListaPracownik = danePracownika.getAttribute("value");
        Assertions.assertEquals(getValueListaPracownik, (wyborKomorkiPracownik(indeksWiersz, indeksKolumna)));
        return this;
    }

    @Step
    public MakeOrderPage setHourAndMinute(String hour, String minutes) throws InterruptedException {
        Thread.sleep(2000);
        hourField.clear();
        hourField.sendKeys(hour);
        minutesField.clear();
        minutesField.sendKeys(minutes);
        return this;
    }

    @Step
    public MakeOrderPage addDay(int iloscDniDoPrzodu) throws InterruptedException {
        dataField.clear();
        LocalDate date = LocalDate.now();
        LocalDate tomorrow = date.plusDays(iloscDniDoPrzodu);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String result = formatter.format(tomorrow);
        dataField.sendKeys(result);
        return this;
    }

    @Step
    public MakeOrderPage orderIn20Minutes() {
        int i = 0;
        while (i < 21) {
            minuteButtonPlus.click();
            i++;
        }
        return this;
    }

    @Step
    public MakeOrderPage orderInOneHour() {
        hourButtonPlus.click();
        return this;
    }


    @Step
    public MakeOrderPage orderInXMinutes(int minutes) {
        int i = 0;
        while (i < minutes) {
            minuteButtonPlus.click();
            i++;
        }
        return this;
    }

    @Step
    public CorporationClientPage openUserHistory() {
        historiaDzwoniacegoButton.click();
        return new CorporationClientPage().verifyCorporationClientPage();
    }

    @Step
    public StarszaWersjaPaneluPage openStarszaWersjaPanelu() {
        starszaWersjaPaneluButton.click();
        return new StarszaWersjaPaneluPage().verifyStarszaWersjaPanelu();
    }

    @Step
    public MakeOrderPage zglosBlad() {
        zglosBladButton.click();
        Assertions.assertTrue(opiszProblemArea.isDisplayed());
        opiszProblemArea.sendKeys("nic się nie stało");
        zglosButtonZgloszenieBledu.click();
        alertPotwierdzenieZgloszeniaBledu.isDisplayed();
        Assertions.assertEquals("Zgłoszenie zostało zapisane.", alertPotwierdzenieZgloszeniaBledu.getText());
        zamknijButtonPotwierdzenieZgloszeniaBledu.click();
        return this;
    }

    @Step
    public SesjePage openSesjePage() throws AWTException, InterruptedException {
        narzedziaButton.click();
        sesjeButton.click();
        Thread.sleep(2000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        return new SesjePage().verifySesjePage();
    }

    @Step
    public StatystykiPage openStatystykiPage() throws InterruptedException, AWTException {
        narzedziaButton.click();
        statystykiButton.click();
        Thread.sleep(2000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        return new StatystykiPage().verifyStatystyiPage();
    }

    @Step
    public RaportyPage openRaportyPage() throws InterruptedException, AWTException {
        narzedziaButton.click();
        raportyButton.click();
        Thread.sleep(2000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        return new RaportyPage().verifyRaportyPage();
    }


    @Step
    public MonitoringOdrzuconychZlecenPage openMonitoringOdrzuconychZlecenPage() throws InterruptedException, AWTException {
        narzedziaButton.click();
        monitoringOdrzuconychZlecenButton.click();
        Thread.sleep(2000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        return new MonitoringOdrzuconychZlecenPage().verifyMonitoringOdrzuconychZlecenPage();
    }

    @Step
    public MakeOrderPage selectAutomatyczneOdswiezanieListyCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        automatyczneOdswiezanieListCheckbox.click();
        Assertions.assertTrue(automatyczneOdswiezanieListCheckbox.isSelected());
        Thread.sleep(3000);
        return this;
    }

    @Step
    public MakeOrderPage unselectAutomaczneDopasowywanieWidoku() throws InterruptedException {
        Thread.sleep(2000);
        automatyczneDopasowanieWidokuCheckbox.click();
        Assertions.assertFalse(automatyczneDopasowanieWidokuCheckbox.isSelected());
        Thread.sleep(3000);
        return this;
    }

    @Step
    public MakeOrderPage selectOnlySundays() throws InterruptedException {
        dateField.clear();
        LocalDate date = LocalDate.now();
        DayOfWeek dateTimeDayOfWeek = date.getDayOfWeek();
        LocalDate saturday = null;

        switch (dateTimeDayOfWeek) {
            case MONDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.MONDAY)) {
                    saturday = date.plusDays(6);
                }
                break;
            case TUESDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.TUESDAY)) {
                    saturday = date.plusDays(5);
                }
                break;
            case WEDNESDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
                    saturday = date.plusDays(4);
                }
                break;
            case THURSDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.THURSDAY)) {
                    saturday = date.plusDays(3);
                }
                break;
            case FRIDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.FRIDAY)) {
                    saturday = date.plusDays(2);
                }
                break;
            case SATURDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.SATURDAY)) {
                    saturday = date.plusDays(1);
                }
                break;
            default: {
                saturday = date;
            }
            break;
        }
        dateField.sendKeys(saturday.toString());
        Thread.sleep(2000);
        zamknijCalendarButton.click();
        return this;
    }

    @Step
    public MakeOrderPage verifyAlertDays() {
        waitForVisibilityOfElement(alertDniTygodnia);
        String alertText = alertDniTygodnia.getText();
        Assertions.assertEquals("Voucher nie pozwala na zamówienie taksówki (limit dni tygodnia)", alertText);
        return this;
    }

    @Step
    public MakeOrderPage chooseInvalidHourVoucher() throws IOException, InterruptedException {
        Thread.sleep(2000);
        waitForVisibilityOfElement(voucherButton);
        voucherButton.click();
        numerVouchera.sendKeys(wyborKomorkiVoucher(13, 0));
        sprawdzButton.click();
        String alertText = alertGodziny.getText();
        Assertions.assertEquals("Voucher nie pozwala na zamówienie taksówki (limit godzinowy od 18 do 23)", alertText);
        zamknijErrorVoucherButton.click();
        profilBiznesowyButton.isSelected();
        return this;
    }

    @Step
    public MakeOrderPage chooseMaxTariffLimitVoucher() throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(voucherButton);
        voucherButton.click();
        numerVouchera.sendKeys(wyborKomorkiVoucher(14, 0));
        sprawdzButton.click();
        String alertText = alertMaxTaryfa.getText();
        Assertions.assertEquals("Voucher nakłada ograniczenie na maksymalną taryfę: 2.40 zł.", alertText);
        zastosujVoucherButton.click();
        return this;
    }

    @Step
    public MakeOrderPage choosePopularTaxiLimitVoucher() throws Exception {
        Thread.sleep(2000);
        waitForVisibilityOfElement(voucherButton);
        voucherButton.click();
        numerVouchera.sendKeys(wyborKomorkiVoucher(15, 0));
        sprawdzButton.click();
        String alertText = alertKlasaPopularna.getText();
        Assertions.assertEquals("Voucher nakłada ograniczenie na klasę samochodu: .", alertText);
        zastosujVoucherButton.click();
        return this;
    }


}









