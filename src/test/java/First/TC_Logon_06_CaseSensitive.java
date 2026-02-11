package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Logon_06_CaseSensitive {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement Username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Username.sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".oxd-button")).click();
        System.out.println("Login Successful");
	}

}
