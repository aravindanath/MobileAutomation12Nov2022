package DeepLinking;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ExampleDeeplinking {

    protected AndroidDriver driver;
    @BeforeTest
    public void setup() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
        desiredCapabilities.setCapability("appPackage","com.swaglabsmobileapp");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("deviceName","emulator-5556");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public  void deeplink(){


        HashMap<String, String> deepUrl = new HashMap<>();
        deepUrl.put("url", "waglabs://checkout-overview/1,2");
        deepUrl.put("package", "com.swaglabsmobileapp");
        driver.executeScript("mobile: deepLink", deepUrl);

    }
}
