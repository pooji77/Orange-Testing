package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import keywords.CommonDropdown;

public class Admin {


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
       // WebElement Admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")));
        //Admin.click();
        
        DynamicClick.clickMenu(driver, "Admin");
        //driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")).click();
        //driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Admin");
        WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));
        User.sendKeys("Admin");
        
        CommonDropdown.selectDropdown(driver, "User Role", "Admin");
       // CommonDropdown.selectEmployeeName(driver, "Ranga  Akunuri");
        CommonDropdown.selectDropdown(driver, "Status", "Enabled");
        driver.findElement(By.xpath("//button[text()=' Search ']")).click();
        driver.findElement(By.xpath("//button[text()=' Reset ']")).click();	 

	}

}
