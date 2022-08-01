package Setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppSetup {

    public AndroidDriver driver;

    @BeforeClass
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "MotoEdge20");
        cap.setCapability("platformName","Android");
        cap.setCapability("udid","ZD2224CW6N");
        cap.setCapability("appPackage","com.continuum.emi.calculator");
        cap.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        return driver;
    }


}
