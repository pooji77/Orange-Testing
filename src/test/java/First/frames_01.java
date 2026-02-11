package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class frames_01 {

	public static void main(String[] args)  {
		WebDriver driver=new ChromeDriver();
		 
		driver.get("https://demoqa.com/");
				
		driver.manage().window().maximize();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement framePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[viewBox='0 0 14 16']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", framePage);
        framePage.click();
        
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Frames']")));
        frame.click();
        
        /*driver.switchTo().frame("frame1");
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        WebElement frameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameElement);*/
        
        WebElement f1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame1")));
        driver.switchTo().frame(f1);

        WebElement heading = driver.findElement(By.id("sampleHeading"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", heading);

        System.out.println("Text inside frame1: " + heading.getText());

        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page"); 
     
        WebElement f2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(f2);
    
        JavascriptExecutor js = (JavascriptExecutor) driver;
       
        js.executeScript("arguments[0].scrollTop = 200;", driver.findElement(By.tagName("body")));  
        js.executeScript("arguments[0].scrollLeft = 200;", driver.findElement(By.tagName("body"))); 
        WebElement heading2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text inside frame2: " + heading2.getText());

        driver.switchTo().defaultContent();

	}

}
