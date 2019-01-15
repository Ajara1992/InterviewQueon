import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SeleniumExceptoins {
    WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);

        driver.get("https://amazon.com");

    }
    @Test
    public void test (){
        WebElement navLink = driver.findElement(By.id("nav-link-accountList"));
        Actions action = new Actions(driver);
        action.moveToElement(navLink).perform();
     driver.findElement(By.xpath("//span[.='Create a List']")).click();
     WebElement searchInputBox = driver.findElement(By.id("twotabsearchtextbox"));
     searchInputBox.sendKeys("Laptop" + Keys.ENTER);
     WebElement _64_gbRamCheckBox = driver.findElement(By.xpath("//span[.='16 GB & Above'] [@class='a-label a-checkbox-label']"));

     _64_gbRamCheckBox.click();
    // driver.navigate().refresh();
        try {

            WebElement i7CheckBox = driver.findElement(By.xpath("//span[.='Intel core i7'] [@class='a-label a-checkbox-label']"));
            i7CheckBox.click();
        }catch (StaleElementReferenceException e) {
            System.out.println("exception thrown");
            WebElement i7CheckBox = driver.findElement(By.xpath("//span[.='Intel core i7'] [@class='a-label a-checkbox-label']"));

        }
    }

}
