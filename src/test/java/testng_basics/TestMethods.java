package testng_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestMethods {

    WebDriver driver=null;

    @BeforeClass
    public void launchBrowser(){
        //disable browser popup
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
//        Map<String, Object> pref=new HashMap<>();
//        pref.put("credentials_enable_service", false);
//        pref.put("profile.password_manager_enabled", false);
//        options.setExperimentalOption("prefs", pref);
        System.out.println("Launch Browser");
        //launch browser
        driver=new ChromeDriver(options);
        //set timeout to fetch element
        driver.manage().timeouts().implicitlyWait(Duration.of(10, TimeUnit.SECONDS.toChronoUnit()));
        //maximize screen
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void login(){
        System.out.println("Login to app");
       driver.get("https://www.saucedemo.com/v1/");
       driver.findElement(By.id("user-name")).sendKeys("standard_user");
       driver.findElement(By.id("password")).sendKeys("secret_sauce");
       driver.findElement(By.id("login-button")).click();
    }

    @Test(priority = 0)
    public void validateItemAddedToCart(){
        System.out.println("Inside method one");
        String pageTitle=driver.getTitle();
        Assert.assertEquals(pageTitle, "Swag Labs",
                "expected page title is `Swag Labs`, but found "+pageTitle);
        driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
        String actual_cart_count=driver.findElement(By.xpath("//span[contains(@class,'shopping_cart_badge')]")).getText();
        Assert.assertEquals(actual_cart_count, "1", "expected count is 1 but found "+actual_cart_count);
        boolean isRemoveBtn=driver.findElement(By.xpath("//button[contains(text(),'REMOVE')]")).isDisplayed();
        Assert.assertTrue(isRemoveBtn, "expected remove button but didn't found");
    }

    @Test(priority = 1)
    public void validateAddAllItemsToCartAndVerifyTheCartCount(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent()).accept();
        List<WebElement> cartList = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        for(int i=0;i< cartList.size();i++){
            cartList.get(i).click();
        }
        String cartCount = driver.findElement(By.xpath("//span[contains(@class,'shopping_cart_badge')]")).getText();
        Assert.assertEquals(cartCount,"6","expected 6 but got "+cartCount);
        List<WebElement> removeButtonCount = driver.findElements(By.xpath("//button[text()='REMOVE']"));
        Assert.assertEquals(removeButtonCount.size(), "6");
    }

    @AfterMethod
    public void logoff(){
        System.out.println("Logoff from app");
        driver.findElement(By.xpath("//div[@class='bm-burger-button']")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @AfterClass
    public void closeBrowser(){
        System.out.println("close browser");
        driver.quit();
    }
}
