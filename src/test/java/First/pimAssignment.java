package First;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;	 
import base.BaseTest;
import pages.Adminpage;
import pages.Loginpage;
import pages.Pimpage;
import pages.Dashboardpage;

		public class pimAssignment extends BaseTest {
				 Loginpage loginPage;
				 Pimpage pimPage;
				 Adminpage adminPage;
				 Dashboardpage dashboard;
		@BeforeMethod
		public void setUpPages() {
		loginPage = new Loginpage(driver);
		pimPage = new Pimpage(driver);
		adminPage = new Adminpage(driver);

	}

		@Test
		public void verifyLogin() throws InterruptedException {
		 loginPage.login("Admin", "admin123");

		 pimPage.ClickPim();
				        
		 Assert.assertTrue(pimPage.isPimPageDisplayed(), "Pim page is not displayed!");
			  
		 pimPage.ClickAdd();
			  
		 pimPage.addEmployeeDetails("Test", "Poojitha123");
		 pimPage.ClickCreateLogin();
		 pimPage.addDetails("testpoojitha1234","testpoojitha123", "testpoojitha123");
		 pimPage.ClickSave();
	     pimPage.verifySuccessMessage("Successfully Saved");
	     
	     String empId = pimPage.getEmployeeId();
	     System.out.println("Employee ID: " + empId);
	     Assert.assertNotNull(empId, "Employee ID field is null!");
	     Assert.assertFalse(empId.trim().isEmpty(), "Employee ID field is empty!");
	     Assert.assertTrue(empId.matches("\\d+"), "Employee ID should be numeric!");
	 	 pimPage.clickAdminMenu();
         pimPage.admin("testpoojitha1234");
	 	 pimPage.search();
	 	 pimPage.edit();
	     pimPage.selectUserRole("Admin");
	     pimPage.ClickSave();
	     pimPage.verifySuccessMessage("Successfully Updated");
	     Thread.sleep(5000);
	     pimPage.logout();

	} 
		@Test(priority = 1)
	    public void validateLogin() throws InterruptedException {
	        Loginpage login = new Loginpage(driver);
	 
	        
	        login.login("testpoojitha1234", "testpoojitha123");
	        
	        pimPage.clickAdminMenu();
	         pimPage.admin("testpoojitha1234");
		 	 pimPage.search();
		 	 pimPage.edit();
		 	 pimPage.yesCheck();
			 pimPage.PasswordChange("testpoojitha1234", "testpoojitha1234");
			 pimPage.ClickSave();
		     pimPage.verifySuccessMessage("Successfully Updated");

			 Thread.sleep(5000);
		     pimPage.logout();
  }
		@Test(priority = 2)
	    public void Login(){
	        Loginpage login = new Loginpage(driver);
	 
	        login.validateLoginModule();
	   
	        login.login("testpoojitha1234", "testpoojitha1234");
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("Current URL after login: " + currentUrl);

	        Assert.assertTrue(currentUrl.contains("dashboard"), "User not redirected to Dashboard!");

		}
}
