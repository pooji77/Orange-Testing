package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Logon_07_Characterlimit {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
        WebElement Username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Username.sendKeys("asdhbgfrwety8920opwslkmnxbvryg");
        driver.findElement(By.name("password")).sendKeys("avcfxdswq23456789oikjmnbvcxdfg");
        driver.findElement(By.cssSelector(".oxd-button")).click();
        
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content")));
        
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Invalid credentials";
        
        if (actualMessage.equalsIgnoreCase(expectedMessage)) {
            System.out.println("Test Passed: Invalid credentials message is displayed.");
        } else {
            System.out.println("Test Failed: Invalid credentials message is not displayed." );
        }    
	
	}

}
