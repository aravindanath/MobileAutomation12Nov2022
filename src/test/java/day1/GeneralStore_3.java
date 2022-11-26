package day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneralStore_3 extends BaseClass{

    @Test
    public  void test1(){


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

       

    }
}
