import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author rasha
 * @since 5/3/2018
 */
public class TherapTest {

    AppiumDriver driver;

    @Before
    public void setupTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platormName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "D://appium//app//therap-5.0-SNAPSHOT-debug.apk");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    private void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        System.out.println(pressX); //pressX, bottomY, pressX, topY
        System.out.println(bottomY);
        System.out.println(topY);
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

    /*
     * don't forget that it's "natural scroll" where
     * fromY is the point where you press the and toY where you release it
     */
    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
    }

    @Test
    public void therapLoginTest() {

        setupTest();

        WebElement userName = driver.findElement(By.id("net.therap.app:id/login_name_input"));
        userName.clear();
        userName.sendKeys("ger_all");

        WebElement password = driver.findElement(By.id("net.therap.app:id/password_input"));
        password.clear();
        password.sendKeys("therap321#");

        WebElement providerCode = driver.findElement(By.id("net.therap.app:id/provider_code_input"));
        providerCode.clear();
        providerCode.sendKeys("SQA-TH");

        //scrollDown();
        driver.hideKeyboard();

        WebElement loginButton = driver.findElement(By.xpath("//android.widget.Button[@text='Login']"));
        //System.out.println(loginButton);
        loginButton.click();
    }

    @Test
    public void passwordReset(){
        therapLoginTest();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement pwResetButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='5']/android.widget.ImageView"));
        System.out.println(pwResetButton);
        pwResetButton.click();

    }

    @Test
    public void therapLogoutTest() {
        therapLoginTest();

        WebElement logoutOption = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
        logoutOption.click();
    }

}
