package day1;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class GeneralStore_1 extends BaseClass{

    @Test
    public  void test1(){

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

       List<WebElement> list =  driver.findElements(MobileBy.xpath("//android.widget.TextView"));

       System.out.println("List of country: "+ list.size());
       for(WebElement element : list){
           System.out.println(element.getText());
           if(element.getText().equalsIgnoreCase("Antarctica")){
               element.click();
               break;
           }
       }

       driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Enter name here\")")).sendKeys("Arvid");

       driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textStartsWith(\"Let\")")).click();

    }
}
