package day1;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneralStore_2_XMLCode extends BaseClass{

    @Test
    public  void test1() throws IOException {

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        Generics.scrollAndClick(driver,"Fiji");



        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

       String pgSource =  driver.getPageSource();

       File file = new File("./sourcecode.xml");
       file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        bw.write(pgSource);
        bw.flush();
        bw.close();



    }
}
