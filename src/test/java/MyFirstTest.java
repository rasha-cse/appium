import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
/**
 * @author rasha
 * @since 4/9/2018
 */
public class MyFirstTest {

    AppiumDriver driver;

/*    @Before
    public void setupTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platormName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
//        capabilities.setCapability(MobileCapabilityType.APP, "D:/appium/app/Calculator.apk");
        capabilities.setCapability("noReset", "true");
//        capabilities.setCapability("app", "D:/appium/app/Calculator.apk");
        capabilities.setCapability("appPackage", "com.example.rasha.testapp");
        capabilities.setCapability("appActivity", "com.example.rasha.testapp.MainActivity");

        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //System.out.println("Passed");
    }*/

/*    @Test
    public void selendroidTest() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platormName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
//        capabilities.setCapability("app", "D://appium//app//com.tricolorcat.calculator.apk");
        capabilities.setCapability("app", "D://appium//app//selendroid-test-app.apk");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement displayTextButton = driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest"));
        System.out.println(displayTextButton);
        displayTextButton.click();
    }*/



    @Test
    public void calculatorTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platormName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "D://appium//app//com.tricolorcat.calculator.apk");
//        capabilities.setCapability(MobileCapabilityType.APP, "C://Users//rasha//AndroidStudioProjects//TestApp//app//build//outputs//apk//debug//selendroid-test-app.apk");
        capabilities.setCapability("noReset", "true");
//        capabilities.setCapability("appPackage", "com.example.rasha.testapp");
//        capabilities.setCapability("appActivity", "com.example.rasha.testapp.MainActivity");

        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

         //Click on number 7
        WebElement sevenKey = driver.findElement(By.id("com.tricolorcat.calculator:id/seven"));
        System.out.println(sevenKey);
        sevenKey.click();
        // Click on '+'
        WebElement plusKey = driver.findElement(By.id("com.tricolorcat.calculator:id/plus"));
        plusKey.click();
        // Click on number 5
        WebElement fiveKey = driver.findElement(By.id("com.tricolorcat.calculator:id/five"));
        fiveKey.click();
        // Click on '='
        WebElement equalsKey = driver.findElement(By.id("com.tricolorcat.calculator:id/equal"));
        equalsKey.click();
        // Check the total is correct
        WebElement total = driver.findElement(By.id("com.tricolorcat.calculator:id/display"));
        String totalValue = total.getText();
        Assert.assertTrue(totalValue.equals("12"));
    }


}