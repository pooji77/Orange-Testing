package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Logon_05_EmptyFields {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement usernameRequired = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='oxd-form']/div[1]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")));
        WebElement passwordRequired = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='oxd-form']/div[2]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")));
                
            String actualUserMsg = usernameRequired.getText();
            String actualPassMsg = passwordRequired.getText();
            String expectedMsg = "Required";

            if (actualUserMsg.equals(expectedMsg) && actualPassMsg.equals(expectedMsg)) {
                System.out.println("Test Passed: 'Required' message displayed for both Username and Password.");
            } else {
                System.out.println("Test Failed:");
                System.out.println("Username message: " + actualUserMsg);
                System.out.println("Password message: " + actualPassMsg);
            }   
	}
}
