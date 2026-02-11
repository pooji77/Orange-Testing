package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NotificationUtils {
	

	    public static void verifySuccessNotification(WebDriver driver,  String expectedMessage) {
	        By notificationLocator = By.cssSelector(".oxd-toast"); 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));

	        String actualText = notification.getText().trim();
	        System.out.println("Notification Message: " + actualText);
   
	        Assert.assertTrue(actualText.contains(expectedMessage),
	                "Expected notification message not found. Actual: " + actualText);
	        
	       
			}
	    }

