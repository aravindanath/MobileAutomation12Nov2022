package day2;

import com.google.common.collect.ImmutableMap;
import day1.BaseClass;
import day1.Generics;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Longpress extends BaseClass {

    @Test
    public  void test1() throws InterruptedException {


        WebElement name = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"));
        name.sendKeys("Ariv");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        List<WebElement> addToCart = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));
        System.out.println("Total Addto Cart: "+ addToCart.size());
        for(WebElement ref : addToCart){
            ref.click();
        }
        WebElement carticon  =  driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        if(carticon.isDisplayed()){ // boolean value
            carticon.click();
        }

       List <WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

       ArrayList<String> val = Generics.getTextFromElement(productPrice);
       System.out.println(val);

       String totalAmt = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$","");

        Float price1 = Float.parseFloat(val.get(0));
        Float price2 = Float.parseFloat(val.get(1));
        Float total = Float.parseFloat(totalAmt);

        Float add = price1+price2;
        System.out.println("Adding two Product: " + add);
        System.out.println("Total: " + total);

        Assert.assertEquals(add, total,"Product cost mismatch");

        driver.findElement(By.className("android.widget.CheckBox")).click();

      WebElement tc =   driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//
//      driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//              "elementId",((RemoteWebElement) element).getId(),
//              "x",661,
//              "y",2965,
//              "duration",1000));
//

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();

        Thread.sleep(3000);

        WebElement close = driver.findElement(By.xpath("//*[@text='CLOSE']"));
        Generics.tap(driver,close);
       

    }
}
