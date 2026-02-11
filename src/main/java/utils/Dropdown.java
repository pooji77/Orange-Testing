package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {
	public static void selectMenu(WebDriver driver, String mainMenu, String subMenu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    
        String dropdownXpath = "//span[@class='oxd-topbar-body-nav-tab-item' and normalize-space(text())='" + mainMenu + "']";
        WebElement selectBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath)));
        selectBox.click();

        String optionXpath = "//ul[@role='menu']//a[normalize-space(text())='" + subMenu + "']";
        WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
        dropdownOption.click();
    }
}
