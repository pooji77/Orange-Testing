package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class frames_02 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/");
		
		driver.manage().window().maximize();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement framePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[viewBox='0 0 14 16']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", framePage);
        framePage.click();
        
        WebElement nestedframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Nested Frames']")));
        nestedframe.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nestedframe);
        
        WebElement f1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame1")));
        driver.switchTo().frame(f1);
        
        WebElement parentText = driver.findElement(By.xpath("//body"));
        System.out.println("Parent Frame Text: " + parentText.getText());

        driver.switchTo().frame(0);
       
        WebElement childText = driver.findElement(By.tagName("p"));
        System.out.println("Child Frame Text: " + childText.getText());
        
        driver.switchTo().defaultContent();
       
	}

}
