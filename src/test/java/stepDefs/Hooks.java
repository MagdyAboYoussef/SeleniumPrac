package stepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.Homepage;

import java.util.concurrent.TimeUnit;


public class Hooks {

    public static WebDriver driver;

    @Before
    public static void OpenBrowser()
    {
        // 1- Bridge
        WebDriverManager.chromedriver().setup();


        // 2- create object from chrome browser
        driver = new EdgeDriver();

        //3- Configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 4- navigate to url
        driver.get("https://demo.nopcommerce.com/");
    }


    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
