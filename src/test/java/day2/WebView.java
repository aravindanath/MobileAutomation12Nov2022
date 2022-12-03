package day2;

import day1.BaseClass;
import day1.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebView extends BaseClass {

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

        driver.findElement(By.className("android.widget.Button")).click();
        Thread.sleep(3000);
        Set<String> context = driver.getContextHandles();

        for(String str : context){
            System.out.println(str);
        }

        driver.context(context.toArray()[1].toString());
        System.out.println("Title: "+ driver.getTitle());




       

    }
}
