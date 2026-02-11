package First;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

	public class LoginTestwithExceldata {

	    public static void main(String[] args) throws Exception {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.saucedemo.com/");
	        
	        String username = ExcelData.getData(1, 0);  
	        String password = ExcelData.getData(1, 1);   
	        driver.findElement(By.id("user-name")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("login-button")).click();

	        takeScreenshot(driver, "LoginScreenshot");
	        System.out.println("Login Test Completed");
	    }
	        public static void takeScreenshot(WebDriver driver, String fileName) {
	            try {
	                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                File dest = new File("C:\\Users\\skquo\\Downloads\\" + fileName + ".png");
	                FileHandler.copy(src, dest);
	                System.out.println("Screenshot Saved: " + dest.getAbsolutePath());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        
	    }
	}


