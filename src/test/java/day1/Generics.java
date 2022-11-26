package day1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Generics {


    public static void scroll(WebDriver driver, String text){
        String value = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"));";
        ((AndroidDriver)driver).findElementByAndroidUIAutomator(value);
    }

    public static void scrollAndClick(WebDriver driver, String text){
        String value = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"));";
        ((AndroidDriver)driver).findElementByAndroidUIAutomator(value).click();
    }


    public static ArrayList<String> getTextFromElement(List<WebElement> element){
        System.out.println("Count: "+ element.size());
        ArrayList<String> productPrice = new ArrayList<String>(); // Empty array
        for(WebElement ref : element){
            productPrice.add(ref.getText().replace("$", ""));
        }
        return productPrice;
    }


    public static void addingProducts(List<WebElement> element){
        System.out.println("Count: "+ element.size());
        for(WebElement ref : element){
            ref.click();
               }
    }
}


