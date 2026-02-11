package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.WaitUtils;

	public class Dashboardpage {

	    private WebDriver driver;
	    
	    @FindBy(css = ".oxd-text--h6")
	    private WebElement dashboardTitle;
	    
	    @FindBy(css = "p.oxd-userdropdown-name")
	    private WebElement profileDropdown;

	    public Dashboardpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    public void validateDashboardPage() {
	        WaitUtils.waitForVisibility(driver, dashboardTitle, 30);
	        Assert.assertTrue(dashboardTitle.isDisplayed(), "Dashboard title not visible!");
	        Assert.assertEquals(dashboardTitle.getText(), "Dashboard", "Dashboard title mismatch!");
	        System.out.println("Dashboard page validated successfully!");
	    }
   
	    public String getDashboardTitleText() {
	        return dashboardTitle.getText();
	    }

}
