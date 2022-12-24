package day1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LaunchYoutube {


    @Test
    public void setup() throws Exception {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appActivity","com.google.android.youtube.app.honeycomb.Shell$HomeActivity");
        desiredCapabilities.setCapability("appPackage","com.google.android.youtube");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("deviceName","emulator-5556");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();
        }catch (Exception e){

        }

        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Search']")).click();

        driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("aadvik raj sharma swimming");



    }

}
