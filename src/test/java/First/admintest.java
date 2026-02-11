package First;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Loginpage;
import pages.Pimpage;
import pages.Adminpage;


	
	public class admintest extends BaseTest {

	    Loginpage loginPage;
	    Adminpage adminPage;
		 Pimpage pimPage;


	    @BeforeMethod
	    public void setUpPages() {
	        loginPage = new Loginpage(driver);
	        adminPage = new Adminpage(driver);
			pimPage = new Pimpage(driver);

	    }

	    @Test(priority = 1)
	    public void verifyAdminPageIsVisible() throws InterruptedException {
			
	        loginPage.login("Admin", "admin123");

	 	    adminPage.clickAdminMenu();
            adminPage.admin("Admin");
	        
	        Assert.assertTrue(adminPage.isAdminPageDisplayed(), "Admin page is not displayed!");
	    }    
	               
	    @Test(priority = 2)
	    public void verifyDropdownSelection() {
	        
	        loginPage.login("Admin", "admin123");

	        adminPage.clickAdminMenu();
	        
	        adminPage.selectUserRole("Admin");
	        adminPage.selectStatus("Enabled");
	        
	        adminPage.search();

	        System.out.println("Dropdown selections and search verified successfully.");
 }
	    @Test(priority = 3)
		public void verifyLogin() throws InterruptedException {
		 loginPage.login("Admin", "admin123");

		 pimPage.ClickPim();
				        
		 Assert.assertTrue(pimPage.isPimPageDisplayed(), "Pim page is not displayed!");
			  
		 pimPage.ClickAdd();
			  
		 pimPage.addEmployeeDetails("Tummala", "Poojitha123");
		 pimPage.ClickCreateLogin();
		 pimPage.addDetails("testpoojitha1234","testpoojitha123", "testpoojitha123");
		 pimPage.ClickSave();
	     pimPage.verifySuccessMessage("Successfully Saved");
	    }
	    
	    @Test(priority = 4)
	    public void EmployeeName() {
	        
	        loginPage.login("Admin", "admin123");

	        adminPage.clickAdminMenu();
	        
	        String selectedName = adminPage.enterEmployeeName("Tummala");

	        adminPage.search();
	        
	        System.out.println("Selected Employee Name: " + selectedName);

	        Assert.assertTrue(adminPage.validateEmployeeName(selectedName),"Employee name validation failed!");
	}
}
	
	
