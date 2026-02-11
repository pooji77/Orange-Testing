package First;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.Dashboardpage;
import pages.Loginpage;
	public class logintest extends BaseTest {
	@Test
	public void verifyLogin() {
			
		Loginpage login = new Loginpage(driver);
	    login.login("Admin","admin123");
	    
	    AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	}  
	@Test(priority = 1)
    public void validateLoginModule() {
        Loginpage login = new Loginpage(driver);
 
        login.validateLoginModule();
   
        login.login("Admin", "admin123");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);

        Assert.assertTrue(currentUrl.contains("dashboard"), "User not redirected to Dashboard!");
    }
	
	@Test(priority = 2)
    public void verifyDashboardAfterLogin() {
        
        Loginpage login = new Loginpage(driver);
        Dashboardpage dashboard = new Dashboardpage(driver);
  
        login.login("Admin", "admin123");
   
        dashboard.validateDashboardPage();
 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM", "Browser title mismatch!");
  
        System.out.println("Dashboard header text: " + dashboard.getDashboardTitleText());
    }
	
	
	@Test(priority = 3)
	public void verifyInvalidLoginMessage() {
	    Loginpage login = new Loginpage(driver);
	     
	    login.loginWithInvalidCredentials("adminadmin", "Admin@123");
	    
	    String errorMessage = login.getInvalidLoginMessage();
	    System.out.println("Displayed error message: " + errorMessage);
	    
	    Assert.assertEquals(errorMessage, "Invalid credentials", "Error message mismatch!");
	}
	
	@Test(priority = 4)
	public void verifyInvalidUsernameOnly() {
	    Loginpage login = new Loginpage(driver);

	    login.loginWithInvalidCredentials("adminadmin123", "admin123");

	    String errorMessage = login.getInvalidLoginMessage();
	    System.out.println("Displayed error message for invalid username: " + errorMessage);

	    Assert.assertEquals(errorMessage, "Invalid credentials", "Error message mismatch for invalid username!");
	}
	
	@Test(priority = 5)
	public void verifyInvalidPasswordOnly() {
	    Loginpage login = new Loginpage(driver);

	    
	    login.loginWithInvalidCredentials("Admin", "Admin@123");

	    String errorMessage = login.getInvalidLoginMessage();
	    System.out.println("Displayed error message for invalid password: " + errorMessage);

	    Assert.assertEquals(errorMessage, "Invalid credentials", "Error message mismatch for invalid password!");
	}
	
	@Test(priority = 6)
	public void verifyEmptyFieldErrorMessages() {
	    Loginpage login = new Loginpage(driver);
	    login.verifyEmptyFieldValidation();
	}
	
	@Test(priority = 7)
	public void Characterlimit() {
	    Loginpage login = new Loginpage(driver);
	     
	    login.loginWithInvalidCredentials("adminadminasq12erdsgvbjuytr", "Admin@123aq14rdzWgfdsawertykjhfdxcv");
	    
	    String errorMessage = login.getInvalidLoginMessage();
	    System.out.println("Displayed error message: " + errorMessage);
	    
	    Assert.assertEquals(errorMessage, "Invalid credentials", "Error message mismatch!");
	}
	
	@Test(priority = 8)
    public void Casesensitive() {
        
        Loginpage login = new Loginpage(driver);
        Dashboardpage dashboard = new Dashboardpage(driver);
  
        login.login("admin", "admin123");
   
        dashboard.validateDashboardPage();
 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM", "Browser title mismatch!");
  
        System.out.println("Dashboard header text: " + dashboard.getDashboardTitleText());
    }
}
	
	

