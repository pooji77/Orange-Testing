package First;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Logon_01_and_02_CheckUIElements {
	
    public static void main(String[]args)
    {
    WebDriver driver=new ChromeDriver();
    
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    
    driver.manage().window().maximize();
    
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    
    WebElement Companylogo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']")));
    //System.out.println("Company logo is visible");
    
    if (Companylogo.isDisplayed()) {
        System.out.println("Company logo is visible");
    }
    WebElement loginTitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")));
    System.out.println("Login Title is visible");
    
    WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-login-logo")));
    System.out.println("Logo is visible");
    
    WebElement Testdata=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--gutters oxd-sheet--gray-lighten-2 orangehrm-demo-credentials']")));
    System.out.println("Testdata is visible");
    
    WebElement UsernameIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bi-person")));
    System.out.println("UsernameIcon is visible");
    
    WebElement Username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[.='Username']")));
    System.out.println("Username is visible");
    
    WebElement PasswordIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bi-key")));
    System.out.println("PasswordIcon is visible");
    
    WebElement Password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[.='Password']")));
    System.out.println("Password is visible");
    
    WebElement ForgotPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-login-forgot-header")));
    System.out.println("ForgotPassword is visible");
    
    WebElement CopyRights=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-copyright-wrapper")));
    System.out.println("CopyRights is visible");
    
    
    WebElement Icons=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-login-footer-sm")));
    System.out.println("Icons are visible");
    driver.quit();
    }
}
