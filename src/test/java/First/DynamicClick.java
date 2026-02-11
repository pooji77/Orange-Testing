package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicClick {

	public static void clickMenu(WebDriver driver, String menuName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String dynamicXpath = "//span[text()='" + menuName + "']";
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
        menu.click();
    }
}