package First;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Logon_03_Login {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Login successful!");
        
     /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-dialog-container')]")));

     driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
     
     System.out.println("Popup handled successfully!");*/
  
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

     try {
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-dialog-container')]")));

         driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
         System.out.println("Popup found and handled!");

     } catch (Exception e) {
         System.out.println("Popup NOT displayed — continuing normally.");
     }	}
}