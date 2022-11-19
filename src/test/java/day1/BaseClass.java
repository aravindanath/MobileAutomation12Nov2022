package day1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

   protected AndroidDriver driver;
    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
        desiredCapabilities.setCapability("appPackage","com.androidsample.generalstore");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("deviceName","emulator-5556");
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
