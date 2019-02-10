
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.nativekey.AndroidKey;
        import io.appium.java_client.android.nativekey.KeyEvent;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

        import java.net.MalformedURLException;
        import java.net.URL;

        import static io.appium.java_client.touch.offset.PointOption.point;
        import static java.lang.Thread.sleep;


        public class AliExpressTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;


/*
    //Elements
//    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
//            "android.widget.RelativeLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Google Nexus 5X");
//        caps.setCapability("udid", "WUJ01N4RQ3"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.alibaba.aliexpresshd");
        caps.setCapability("appActivity","com.aliexpress.module.home.MainActivity");
        caps.setCapability("noReset","false");
        caps.setCapability("forceMjsonwp","true");
        caps.setCapability("device","192.168.93.101:5555");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }
*/

            @BeforeMethod
            public void setup () throws MalformedURLException {

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("testobjectApiKey", "DD5EC80C783444D8BCCE9D3118DE11EA");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "8.1.0");
                capabilities.setCapability("deviceName", "LG Nexus 5X Free");
                capabilities.setCapability("app_package", "com.alibaba.aliexpresshd");
                capabilities.setCapability("noReset", "false");
                capabilities.setCapability("automationName", "uiautomator2");
                driver.getCapabilities().getCapability("testobject_test_report_url");
                driver.getCapabilities().getCapability("testobject_test_live_view_url");
                driver = new AndroidDriver<MobileElement>(new URL("https://eu1.appium.testobject.com/wd/hub"),capabilities);


            }






    @Test
    public void signInNegativeTest () throws InterruptedException {

        //Click to menu
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.alibaba.aliexpresshd:id/left_action"))).click();

        //Click to account
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.alibaba.aliexpresshd:id/chosen_account_view"))).click();

        //Click to sign_in
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.alibaba.aliexpresshd:id/btn_sign_in"))).click();

        //Send email
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.alibaba.aliexpresshd:id/et_email"))).sendKeys("tgdj@gmail.com");

        //Send pass
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.alibaba.aliexpresshd:id/et_password"))).sendKeys("qqqqqqq");

        //Click to in
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.alibaba.aliexpresshd:id/rl_ali_sign_in_btn"))).click();

        //Get message
        String expectedText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/message"))).getAttribute("text");

        Assert.assertEquals(expectedText, "Account does not exist. Please register an account to start shopping.");
    }

            @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
