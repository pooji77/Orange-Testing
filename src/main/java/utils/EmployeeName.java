package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class EmployeeName {
		
		public static String selectFromDynamicDropdown(WebDriver driver, By inputLocator, String searchText, String fullName) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
	        input.clear();
	        input.sendKeys(searchText);

	        wait.until(d -> d.findElements(By.xpath("//div[@role='listbox']//div[@role='option']//span")).size() > 0);

	        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@role='listbox']//div[@role='option']//span"));
	        System.out.println("Suggestions found: " + suggestions.size());
	        WebElement first = suggestions.get(0);
	        String selectedText = first.getText();

	        wait.until(ExpectedConditions.elementToBeClickable(first)).click();

	        System.out.println("Selected from dropdown: " + selectedText);
	        WebElement selected = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		    return selected.getAttribute("value");   
	    }
}
