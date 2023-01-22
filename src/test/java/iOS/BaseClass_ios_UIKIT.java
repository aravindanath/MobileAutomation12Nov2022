package iOS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass_ios_UIKIT {

   protected IOSDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("bundleId","com.UIKit.7jan23");
        desiredCapabilities.setCapability("platformName","iOS");
        desiredCapabilities.setCapability("platformVersion","16.2");
        desiredCapabilities.setCapability("automationName","XCUITest");
        desiredCapabilities.setCapability("newCommandTimeout","100");
        desiredCapabilities.setCapability("launchTimeout","800000");
        desiredCapabilities.setCapability("deviceName","iPhone 14 Plus");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"9357CBDF-F33F-406E-B105-2FE209DE6931");
         driver = new IOSDriver(new URL("http://127.0.0.1:4724/"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
/**
 * {
 *   "appium:deviceName": "iPhone 14 Plus",
 *   "appium:automationName": "XCUITest",
 *   "appium:udid": "9357CBDF-F33F-406E-B105-2FE209DE6931",
 *   "platformName": "iOS",
 *   "appium:bundleId": "com.apple.mobileslideshow",
 *   "appium:launchTimeout": "800000",
 *   "appium:platformVersion": "16.2",
 *   "appium:newCommandTimeout": "100"
 * }
 */