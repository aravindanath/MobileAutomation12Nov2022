package day1;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
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

    public static void longPress(WebDriver driver, WebElement element){
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(2))).release().perform();
    }

    public static void tap(WebDriver driver, WebElement element){
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }
}


