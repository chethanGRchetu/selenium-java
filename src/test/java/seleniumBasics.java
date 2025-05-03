import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

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
    void test_02() {
        WebDriver driver = new ChromeDriver();  // launching crome
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/"); //opening filpcart
        System.out.println(driver.getTitle());// getting titile of the fipcart webpage
        //serching
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("basketball");
        driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
        driver.findElement(By.xpath("//a[@title='VECTOR X Target Indoor & Outdoor Rubber Moulded Soft Practice Sports Ball Basketball - Size: 3']")).click();
//        to handle multiple windows or tabs
        Set<String> windows=driver.getWindowHandles();
        System.out.println("windows:");
        windows.stream().forEach(System.out::println);
//        iterate over windows loop check the page title till expected
        for(String window:windows){
            System.out.println("window title: "+ driver.getTitle());
            if(!driver.getTitle().contains("VECTOR X Target Indoor & Outdoor Rubber Moulded Soft Practice Sports Ball Basketball - " +
                    "Size: 3 - Buy VECTOR X Target Indoor & Outdoor Rubber Moulded Soft Practice Sports Ball Basketball -" +
                    " Size: 3 Online at Best Prices in India - Sports & Fitness | Flipkart.com"))
                driver.switchTo().window(window);
            else
                break;
        }
        driver.findElement(By.id("pincodeInputId")).sendKeys("560001");
        driver.findElement(By.xpath("//*[@class='i40dM4']")).click();
        //driver.close();
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
