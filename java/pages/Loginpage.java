package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WaitUtils;
 
public class Loginpage {
	
		
		private WebDriver driver;
	
	    @FindBy(name = "username")
	    WebElement username;
	
	    @FindBy(name = "password")
	    WebElement password;
	
	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement loginBtn;
	    
	    @FindBy(css = ".orangehrm-login-branding")
	    WebElement companyLogo;

	    @FindBy(xpath = "//h5[text()='Login']")
	    WebElement loginTitle;

	    @FindBy(css = ".oxd-sheet")
	    WebElement testDataBox;

	    @FindBy(xpath = "//label[text()='Username']")
	    WebElement usernameLabel;

	    @FindBy(xpath = "//label[text()='Password']")
	    WebElement passwordLabel;

	    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	    WebElement forgotPasswordLink;

	    @FindBy(xpath = "//a[contains(@href,'linkedin')]")
	    WebElement linkedInIcon;

	    @FindBy(xpath = "//a[contains(@href,'facebook')]")
	    WebElement facebookIcon;

	    @FindBy(xpath = "//a[contains(@href,'twitter')]")
	    WebElement twitterIcon;

	    @FindBy(xpath = "//a[contains(@href,'youtube')]")
	    WebElement youtubeIcon;

	    @FindBy(css = ".orangehrm-copyright-wrapper")
	    WebElement copyrightText;

	    @FindBy(css = ".oxd-alert-content")
        WebElement invalidLoginMessage;

	    @FindBy(xpath = "//span[text()='Required'][1]")
	    WebElement usernameRequiredMsg;

	    @FindBy(xpath = "(//span[text()='Required'])[2]")
	    WebElement passwordRequiredMsg;

	    public Loginpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	    public void login(String user, String pass) {
	    
	    	WaitUtils.waitForVisibility(driver,username,30);
	        username.sendKeys(user);
	        password.sendKeys(pass);
	        loginBtn.click();
	    }
	    public void validateLoginModule() {
	        WaitUtils.waitForVisibility(driver, username, 30);
	        Assert.assertTrue(username.isDisplayed(), "Username field not visible");
	        Assert.assertTrue(password.isDisplayed(), "Password field not visible");
	        Assert.assertTrue(loginBtn.isDisplayed(), "Login button not visible");
	        System.out.println("Login module validated successfully.");
	   

	        Assert.assertTrue(companyLogo.isDisplayed(), "Company logo not visible");
	        Assert.assertTrue(loginTitle.isDisplayed(), "Login title not visible");
	        Assert.assertTrue(testDataBox.isDisplayed(), "Test data box not visible");
	        Assert.assertTrue(usernameLabel.isDisplayed(), "Username label not visible");
	        Assert.assertTrue(passwordLabel.isDisplayed(), "Password label not visible");
	        Assert.assertTrue(forgotPasswordLink.isDisplayed(), "Forgot password link not visible");

	        Assert.assertTrue(linkedInIcon.isDisplayed(), "LinkedIn icon not visible");
	        Assert.assertTrue(facebookIcon.isDisplayed(), "Facebook icon not visible");
	        Assert.assertTrue(twitterIcon.isDisplayed(), "Twitter icon not visible");
	        Assert.assertTrue(youtubeIcon.isDisplayed(), "YouTube icon not visible");
	        Assert.assertTrue(copyrightText.isDisplayed(), "Copyright text not visible");

	        System.out.println("All Login Page UI elements verified successfully.");
	        
	    }  
//Invalid Credentials	    
	    
	       public void loginWithInvalidCredentials(String user, String pass) {
	            WaitUtils.waitForVisibility(driver, username, 20);
	            username.sendKeys(user);
	            password.sendKeys(pass);
	            loginBtn.click();
	        }

	        public String getInvalidLoginMessage() {
	            WaitUtils.waitForVisibility(driver, invalidLoginMessage, 30);
	            return invalidLoginMessage.getText();
	        }
//Empty Fields
	        
	        public void verifyEmptyFieldValidation() {
	            
	            WaitUtils.waitForVisibility(driver, username, 30);
	            
	            loginBtn.click();

	            WaitUtils.waitForVisibility(driver, usernameRequiredMsg, 30);
	            WaitUtils.waitForVisibility(driver, passwordRequiredMsg, 30);
	            
	            Assert.assertEquals(usernameRequiredMsg.getText(), "Required", "Username required message missing!");
	            Assert.assertEquals(passwordRequiredMsg.getText(), "Required", "Password required message missing!");
	            
	            System.out.println("Empty field validation messages verified successfully.");
	        }
// Character limit
	        public void Characterlimit(String user, String pass) {
	            WaitUtils.waitForVisibility(driver, username, 30);
	            username.sendKeys(user);
	            password.sendKeys(pass);
	            loginBtn.click();
	        }

	        public String getInvalidMessage() {
	            WaitUtils.waitForVisibility(driver, invalidLoginMessage, 30);
	            return invalidLoginMessage.getText();
	        }    
	        
	}

	    
	