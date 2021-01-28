import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class baseClass {
    WebDriver driver;


    @BeforeTest
    public landingScreen initializeDriver  () {
        try {
            //Major reasons for the try-catch is to stacktrace errors encountered when initializing driver in the console
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //Created desiredCapabilities object as "capabilities" to handle all driver configurations
            capabilities.setCapability("BROWSER_NAME", "Android");
            //Set android deviceName desired capability
            capabilities.setCapability("deviceName", "emulator-5554");
            //Set android platformName desired capability to Android
            capabilities.setCapability("platformName", "Android");
            //Set android VERSION from device desired capability.
            capabilities.setCapability("platformVersion", "10.0.0");
            // Set android appPackage desired capability.
            capabilities.setCapability("appPackage", "com.daretoinnovate.oze");
            // Set android appActivity desired capability.
            capabilities.setCapability("appActivity", "presentation.ftue.TutorialsActivity");
            //capabilities.setCapability("app", "src/main/resources/App/HRMS app-release 1.apk");
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);
            // Set android autoAcceptAlerts to override all alerts
            capabilities.setCapability("autoAcceptAlerts", true);
            // Set android autoGrantPermissions to override all Permissions
            capabilities.setCapability("autoGrantPermissions", true);
            //This is to enable Appium API interact with connected device or emulator
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return new landingScreen(driver);
            //Lastly returned the homeScreen to enable initialization object in homeScreen page elements.
        } catch (Exception e) {
            System.out.println("Cause is : " + e.getCause());
            System.out.println("Cause is : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @AfterTest
    public void tearDown () {
        driver.quit();

    }
}

