package day1;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralStore_2 extends BaseClass{

    @Test
    public  void test1(){

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        Generics.scrollAndClick(driver,"Fiji");

        WebElement name = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"));
        name.click();

        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.R));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.V));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.I));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.N));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.D));
        if(((AndroidDriver)driver).isKeyboardShown())
             ((AndroidDriver)driver).hideKeyboard();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        List<WebElement> addToCart = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));
        Generics.addingProducts(addToCart);


       WebElement carticon  =  driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));

        if(carticon.isDisplayed()){ // boolean value
            carticon.click();
        }

       List <WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

       ArrayList<String> val = Generics.getTextFromElement(productPrice);
       System.out.println(val);

       String totalAmt = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();



    }
}
