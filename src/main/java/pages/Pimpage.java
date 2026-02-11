package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonDropdown;
import utils.NotificationUtils;
import utils.WaitUtils;

public class Pimpage {
	private WebDriver driver;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
	WebElement ClickPIM;
	
	@FindBy(css = ".oxd-text--h6")
	WebElement pimHeader;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addButton;
 
    @FindBy(xpath = "//input[@name='firstName']")
	WebElement FirstName;
    
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement LastName;
	
	@FindBy(css = ".oxd-switch-input")
	WebElement CreateLoginDetailsbutton;
	
	 @FindBy(css = ".orangehrm-employee-form > .oxd-form-row [data-v-304890b0] [autocomplete='off']")
	 WebElement Userame;
	 
	 @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input[@class='oxd-input oxd-input--active']")
	 WebElement Password;
	 
	 @FindBy(xpath = "//div[@class='oxd-form-row user-password-row']//div[@class='oxd-grid-item oxd-grid-item--gutters']//input[@class='oxd-input oxd-input--active']")
	 WebElement ConfirmPassword;
	 
	 @FindBy(css = ".oxd-button--secondary")
	 WebElement SaveButton;
	 
	 @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	 WebElement employeeIdInput;
	 
	 @FindBy(xpath = "//span[text()='Admin']")
     WebElement adminMenu;
	 
	 @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//input[@class='oxd-input oxd-input--active']")
	 WebElement AdminUsername;
	 
	 @FindBy(xpath = "//button[@type='submit']")
	 WebElement searchButton;
	 
	 @FindBy(css = ".bi-pencil-fill")
	 WebElement editButton;
	 
	 @FindBy(css = ".oxd-userdropdown-icon")
	 WebElement userDropdownIcon;

	 @FindBy(xpath = "//a[text()='Logout']")
	 WebElement logoutButton;

	 @FindBy(xpath = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']\r\n")
	 WebElement YesCheckbox;
	 
    public Pimpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void ClickPim() {
		WaitUtils.waitForVisibility(driver, ClickPIM, 10);
		ClickPIM.click();
    }
    
    public boolean isPimPageDisplayed() {
        return WaitUtils.waitForVisibility(driver, pimHeader, 30).isDisplayed();
    }
    
    public void ClickAdd() {
		WaitUtils.waitForVisibility(driver, addButton, 10);
		addButton.click();
    }
    
	public void addEmployeeDetails(String firstname, String lastname) {
		WaitUtils.waitForVisibility(driver, FirstName, 10);
		FirstName.sendKeys(firstname);
		WaitUtils.waitForVisibility(driver, LastName, 10);
		LastName.sendKeys(lastname);
	}
	 public void ClickCreateLogin() {
			WaitUtils.waitForVisibility(driver, CreateLoginDetailsbutton, 10);
			CreateLoginDetailsbutton.click();
	    }
	 public void addDetails(String username, String password,String confirmpassword) {
			WaitUtils.waitForVisibility(driver, Userame, 10);
			Userame.sendKeys(username);
			WaitUtils.waitForVisibility(driver, Password, 10);
			Password.sendKeys(password);
			WaitUtils.waitForVisibility(driver, ConfirmPassword, 10);
			ConfirmPassword.sendKeys(confirmpassword);
		}
	 public void ClickSave() {
			WaitUtils.waitForVisibility(driver, SaveButton, 10);
			SaveButton.click();
	    }
	 public void verifySuccessMessage(String message) {
	        NotificationUtils.verifySuccessNotification(driver, message);
	    }
	 public String getEmployeeId() {
	        return employeeIdInput.getAttribute("value");
	    }
	 public void clickAdminMenu() {
	        WaitUtils.waitForVisibility(driver, adminMenu, 30);
	        adminMenu.click();
	    }
	 public void admin(String user) {
     	WaitUtils.waitForVisibility(driver, AdminUsername, 30);	
	       AdminUsername.sendKeys(user);
     } 
	        public void search() {
	        	WaitUtils.waitForVisibility(driver, addButton, 30);	
		        searchButton.click();
   }	
	        public void edit() {
	        	WaitUtils.waitForVisibility(driver, editButton, 30);	
		        editButton.click();
   }	
	        public void selectUserRole(String role) {
	            CommonDropdown.selectDropdown(driver, "User Role", role);
	        }
	        public void logout() {
	            
	            WaitUtils.waitForVisibility(driver, userDropdownIcon, 10);
	            userDropdownIcon.click();
	            
	            WaitUtils.waitForVisibility(driver, logoutButton, 10);
	            logoutButton.click();
	        }

	        public void yesCheck() {
	        	WaitUtils.waitForVisibility(driver, YesCheckbox, 30);	
	        	YesCheckbox.click();
   }	
	        public void PasswordChange( String password,String confirmpassword) {
				
				WaitUtils.waitForVisibility(driver, Password, 10);
				Password.sendKeys(password);
				WaitUtils.waitForVisibility(driver, ConfirmPassword, 10);
				ConfirmPassword.sendKeys(confirmpassword);
			}		
}
