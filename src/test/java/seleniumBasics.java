import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class seleniumBasics {

//    public static void main(String[] args) {
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/v1/");
//        System.out.println(driver.getTitle());
//        driver.close();
//    }
//

//    @Test
//    void test_01(){
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/v1/");
//        System.out.println(driver.getTitle());
//        driver.close();
//    }

    @Test
    void test_02(){
        WebDriver driver=new ChromeDriver();  // launching crome
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/"); //opening filpcart
        System.out.println(driver.getTitle());// getting titile of the fipcart webpage
        //serching
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("basketball");
        driver.findElement(By.xpath("//button[@class=\"_2iLD__\"]")).click();
        driver.findElement(By.linkText("NIVIA GRAFFITI Basketball - Size: 7")).click();
        driver.close();
    }

//    @Test
//    void test_03(){
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.amazon.in/");
//        System.out.println(driver.getTitle());
//        driver.close();
//    }
}
