package First;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignmenttest {
public static void main(String[] args) {
		
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--disable-features=PasswordManager");
	    options.addArguments("--disable-features=PasswordLeakDetection");

	    WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sauce Labs Onesie']")));
        
        String priceText = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/following::div[@class='inventory_item_price'][1]")).getText();
        System.out.println("Product Price: " + priceText);

        WebElement addBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        addBtn.click();
        
        WebElement removeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));
        System.out.println("Product successfully added to cart!");
    
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_link")));

        String cartQty = cartIcon.getText();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);

        cartIcon.click();
 
        String cartDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name"))).getText();

        String cartPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();

        System.out.println("Cart Qty = " + cartQty);
        System.out.println("Cart Product Name = " + cartDesc);
        System.out.println("Cart Price = " + cartPrice);

        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        checkout.click();
        
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstname.sendKeys("Tummala");

        driver.findElement(By.id("last-name")).sendKeys("poojitha");
        driver.findElement(By.id("postal-code")).sendKeys("522262");
        driver.findElement(By.id("continue")).click();

        String cartDesc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name"))).getText();

        String cartPrice1 = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        System.out.println("Cart Qty = " + cartQty);
        System.out.println("Cart Product Name = " + cartDesc1);
        System.out.println("Cart Price = " + cartPrice1);

        String itemTotalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".summary_subtotal_label"))).getText();

        String taxText = driver.findElement(By.cssSelector(".summary_tax_label")).getText();

        String totalText = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        System.out.println(itemTotalText);
        System.out.println(taxText);
        System.out.println(totalText);
     
        double itemTotal = Double.parseDouble(itemTotalText.split("\\$")[1]);
        double tax = Double.parseDouble(taxText.split("\\$")[1]);
        double total = Double.parseDouble(totalText.split("\\$")[1]);

        if (Math.abs((itemTotal + tax) - total) < 0.001) {
         System.out.println("Final Verification PASSED: Item Total + Tax = Total");
        } else {
         System.out.println("Final Verification FAILED!");
         System.out.println("Calculated: " + (itemTotal + tax));
         System.out.println("Displayed Total: " + total);
     }
        driver.findElement(By.id("finish")).click();
        String thankYouMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".complete-header"))).getText();

    	System.out.println("Order Confirmation: " + thankYouMsg);
    	System.out.println("Thank You Message VERIFIED");
}
}