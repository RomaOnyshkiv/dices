package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    private static WebDriver driver;
    protected final String BASE_URL = "https://www.random.org/dice/";

    @BeforeTest
    public void setupDriver() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts()
                .setScriptTimeout(20, SECONDS)
                .pageLoadTimeout(20, SECONDS)
                .implicitlyWait(20, SECONDS);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    protected WebDriver getDriver() {
        return driver;
    }
}
