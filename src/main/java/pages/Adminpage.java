package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonDropdown;
import utils.EmployeeName;
import utils.WaitUtils;

public class Adminpage {
	
	    private WebDriver driver;

	    @FindBy(xpath = "//span[text()='Admin']")
	     WebElement adminMenu;
	    
	    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//input[@class='oxd-input oxd-input--active']")
	    WebElement Username;

	    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
	    WebElement searchBox;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement searchButton;

	    @FindBy(xpath = "//button[contains(.,'Add')]")
	    WebElement addButton;

	    @FindBy(css = "h5.oxd-text--h5")
	    WebElement adminHeader;
	    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
	    WebElement empNameField;


	    public Adminpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	   public void clickAdminMenu() {
	        WaitUtils.waitForVisibility(driver, adminMenu, 30);
	        adminMenu.click();
	    }

	    public boolean isAdminPageDisplayed() {
	        return WaitUtils.waitForVisibility(driver, adminHeader, 30).isDisplayed();
	    }

	    
	        
	        public void admin(String user) {
	        	WaitUtils.waitForVisibility(driver, addButton, 30);	
		        Username.sendKeys(user);
	        } 
		        public void search() {
		        	WaitUtils.waitForVisibility(driver, addButton, 30);	
			        searchButton.click();
	    }
		        public void selectUserRole(String role) {
		            CommonDropdown.selectDropdown(driver, "User Role", role);
		        }

		        public void selectStatus(String status) {
		            CommonDropdown.selectDropdown(driver, "Status", status);
		        }
		        
		        public String enterEmployeeName(String empName) {
		       return EmployeeName.selectFromDynamicDropdown(driver,By.xpath("//input[@placeholder='Type for hints...']"),empName.substring(0, 3),empName);
		      }
		        
		        public WebElement getEmployeeNameElement(String empName) {
		            String dynamicXpath = "//div[@class='oxd-table-cell oxd-padding-cell']//div[normalize-space()='"
		                                   + empName.trim() + "']";

		            return new WebDriverWait(driver, Duration.ofSeconds(10))
		                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
		        }

		   	        public boolean validateEmployeeName(String empName) {

		            String name = empName.replaceAll("\\s+", " ").trim(); 

		            String dynamicXpath = "//div[@class='oxd-table-cell oxd-padding-cell']//div[contains(normalize-space(),'"
		                                 + name + "')]";

		            WebElement emp = new WebDriverWait(driver, Duration.ofSeconds(10))
		                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));

		            return emp.isDisplayed();
		        }
	   }



