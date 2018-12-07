package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    @Test
    public void launchApp() throws Throwable {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ad06170246f8a75b49");
        caps.setCapability("udid", "ad06170246f8a75b49"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("appPackage", "com.geckolab.eotaxi.passenger.demo");
        caps.setCapability("appActivity", "pl.itaxi.MainActivity");
        caps.setCapability("noReset", "true");
        caps.setCapability("newCommandTimeout", 120);

        try {
            AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
