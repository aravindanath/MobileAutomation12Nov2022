package iOS;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;

public class Test01 extends  BaseClass_ios_UIKIT{


    @Test
    public void test1() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElementByIosClassChain("**/XCUIElementTypeButton[`name == 'UIKitCatalog'`]").click();
        Thread.sleep(2000);

        driver.findElementByIosNsPredicate("type =='XCUIElementTypeStaticText' and  value ='Controls'").click();
        Thread.sleep(2000);

        driver.findElementByIosNsPredicate("label == 'Page Controls' AND name == 'Page Controls'").click();
        Thread.sleep(2000);

        driver.findElementByIosNsPredicate("label == 'Custom Page Control' AND name == 'Custom Page Control'").click();

        Thread.sleep(2000);

        for(int i = 1; i < 14; i++) {
            Thread.sleep(1000);
            driver.findElementByIosClassChain("**/XCUIElementTypePageIndicator[`value contains 'page'`]").click();
            Thread.sleep(1000);
        }

    }
}
