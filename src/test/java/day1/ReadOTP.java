package day1;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReadOTP extends  BaseClass{

    @Test
    public void test() throws InterruptedException {
            Thread.sleep(5000);
            driver.openNotifications();
            Thread.sleep(3000);
            driver.findElement(By.id("android:id/message_text")).click();
            Thread.sleep(5000);

             String otp =  driver.findElement(By.xpath("(//android.widget.TextView[contains(@text,'OTP')])[last()]")).getText();
            Thread.sleep(5000);

              String finalOTP =   Generics.getOTP(otp);
              System.out.println("finalOTP is   " + finalOTP);
              driver.activateApp("com.androidsample.generalstore");// package name
             Thread.sleep(5000);
             driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Enter name here\")")).sendKeys(finalOTP);
                driver.runAppInBackground(Duration.ofSeconds(10));

    }
}
