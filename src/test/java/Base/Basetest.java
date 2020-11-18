package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Basetest {

    private WebDriver driver;
    @BeforeTest
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", "resources/executable/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.edfa3ly.com/cart");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
    @Test
    public void AutomatedProduct(){
        WebElement ItemURL = driver.findElement(By.name("url"));
        ItemURL.sendKeys("https://www.6pm.com/p/product/9409514");
        ItemURL.submit();


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
//            tlDriver.set(null);
        }
    }
}
