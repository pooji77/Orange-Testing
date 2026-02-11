package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Logon_04_Invalid_Credentials {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
//Both Invalid
        
       /* WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("adminadmin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@23");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content")));
        
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Invalid credentials";
        
        if (actualMessage.equalsIgnoreCase(expectedMessage)) {
            System.out.println("Test Passed: Invalid credentials message is displayed.");
        } else {
            System.out.println("Test Failed: Invalid credentials message is not displayed." );
        }*/
        
   //Invalid Username     
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("adminadmin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content")));
        
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Invalid credentials";
        
        if (actualMessage.equalsIgnoreCase(expectedMessage)) {
            System.out.println("Test Passed: Invalid credentials message is displayed.");
        } else {
            System.out.println("Test Failed: Invalid credentials message is not displayed." );
        }
        
        //Invalid Password
        
       /* WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@23");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content")));
        
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Invalid credentials";
        
        if (actualMessage.equalsIgnoreCase(expectedMessage)) {
            System.out.println("Test Passed: Invalid credentials message is displayed.");
        } else {
            System.out.println("Test Failed: Invalid credentials message is not displayed." );
        }*/
        
	}

}
