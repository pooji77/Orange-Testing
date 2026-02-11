package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDropdown {

		 public static void selectDropdown(WebDriver driver, String dropdownLabel, String optionText) {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		        String dropdownXpath = "//label[text()='" + dropdownLabel + "']/following::div[contains(@class,'oxd-select-text-input')][1]";
		        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
		        dropdown.click();

		        String optionXpath = "//div[@role='option']//span[text()='" + optionText + "']";
		        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
		        option.click();
	 }
}