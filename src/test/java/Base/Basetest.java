package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void AutomatedProduct() throws InterruptedException {
        WebElement ItemURL = driver.findElement(By.name("url"));
        ItemURL.sendKeys("https://www.6pm.com/p/product/9409514");
        ItemURL.submit();
        Thread.sleep(1000);
        WebElement EnterSize = driver.findElement(By.name("size"));
        EnterSize.sendKeys("10");
        EnterSize.submit();
        Thread.sleep(1000);
        WebElement AddItem = driver.findElement(By.xpath("//input[@value='Add item']"));
        AddItem.click();
        Thread.sleep(5000);
        WebElement CartDetails = driver.findElement(By.xpath("//div[contains(text(),'Cart Details')]"));
        CartDetails.isDisplayed();
    }
    @Test
    public void ProhibitedProduct() throws InterruptedException {
        WebElement ItemURL = driver.findElement(By.name("url"));
        ItemURL.sendKeys("https://www.abercrombie.com/shop/wd/p/skinny-suede-belt-41330319?categoryId=12266&seq=02&faceout=prod1\n");
        ItemURL.submit();
        Thread.sleep(5000);
        WebElement ProhibitedMessage = driver.findElement(By.xpath("//label[contains(text(),'we apologize, store is not available at this momen')]"));
        ProhibitedMessage.isDisplayed();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
//            tlDriver.set(null);
        }
    }
}
