package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDropdown {

		 public static void selectDropdown(WebDriver driver, String dropdownLabel, String optionText) {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        String dropdownXpath = "//label[text()='" + dropdownLabel + "']/following::div[contains(@class,'oxd-select-text-input')][1]";
		        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
		        dropdown.click();

		        String optionXpath = "//div[@role='option']//span[text()='" + optionText + "']";
		        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
		        option.click();
		    }
		 
		 public static void selectEmployeeName(WebDriver driver, String employeeName) {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        WebElement empNameInput = wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input")));
		        empNameInput.sendKeys(employeeName.substring(0, 2));

		        WebElement empSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[@role='listbox']//span[contains(text(),'" + employeeName + "')]")));
		        empSuggestion.click();

		    }
}
