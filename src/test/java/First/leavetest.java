package First;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.Loginpage;

import pages.Leavepage;
	
	public class leavetest  extends BaseTest {

		 Loginpage loginPage;
		 Leavepage leavePage;

		   @BeforeMethod
		    public void setUpPages() {
		       loginPage = new Loginpage(driver);
		       leavePage = new Leavepage(driver);
}

	@Test
	  public void verifyAdminPageIsVisible() throws InterruptedException {

	  loginPage.login("Admin", "admin123");

	  leavePage.clickLeaveMenu();
		        
	  Assert.assertTrue(leavePage.isLeavePageDisplayed(), "Leave page is not displayed!");
}  
	@Test(priority = 1)
	public void verifyDropdownSelection() {
		        
	loginPage.login("Admin", "admin123");

	leavePage.clickLeaveMenu();
		        
	leavePage.selectLabel("Add Entitlements");
		    
	System.out.println("Dropdown selections and search verified successfully.");
}
		    
      @Test(priority = 2)
		public void validateLeaveModule() {
		    	
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		        
		Leavepage leave = new Leavepage(driver);
		 
		leave.validateLeaveModule();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL after leave page: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("Leave"), "User not redirected to Dashboard!");	       
}
		    
	@Test(priority = 3)
	  public void verifyDropdownUI() throws InterruptedException {
		loginPage.login("Admin", "admin123");
		leavePage.clickLeaveMenu();
        leavePage.validateDropdownLabels();
}
		    
	@Test(priority = 4)
	  public void verifyNoLeaveTypesMessage() {
		loginPage.login("Admin", "admin123");
		        
		leavePage.clickLeaveMenu();

		leavePage.ApplyPage();
 
		leavePage.verifyApplyMessage();
}
	 @Test(priority = 5)
	  public void verifyLeaveDateSelection() {
		    	
        loginPage.login("Admin", "admin123");
		        
		leavePage.clickLeaveMenu();
		        
		leavePage.LeavePage();

		leavePage.enterFromAndToDates("2024-20-11", "2024-25-11");

		leavePage.selectLeaveType("US - Personal");
		        
		leavePage.clickSearch();
		        
		leavePage.verifySuccessMessage("No Records Found");
}	
	 @Test(priority = 6)
		public void Entitlements()  {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		
		leavePage.selectLabel("Add Entitlements");
		
     leavePage.enterEmployeeName("Ranga  Akunuri");
		leavePage.selectLeaveType("CAN - Personal");
	    leavePage.selectLeavePeriod("2024-01-01 - 2024-31-12");
	    leavePage.Entitlement("1");
	    leavePage.clickSave(); 
	    leavePage.clickConfirm(); 
     leavePage.verifySuccessMessage("Successfully Saved");

}	    
	  @Test(priority = 7)
	   public void LeaveReports() {
			        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
			        
		leavePage.selectReportsLabel("Leave Entitlements and Usage Report");
			        
		leavePage.selectLeaveType("CAN - Personal");
		leavePage.selectLeavePeriod("2024-01-01 - 2024-31-12");
		leavePage.selectLocation("New York Sales Office");
	    leavePage.selectSubUnit("Administration");
	    leavePage.selectJobTitle("Finance Manager");
	    leavePage.clickGenerate();
		leavePage.verifySuccessMessage("No Records Found");
}
		    
	  @Test(priority = 8)
	   public void verifyRecordsFoundMessage() {
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu(); 
			        
		leavePage.selectReportsLabel("My Leave Entitlements and Usage Report");
	    leavePage.selectLeavePeriod("2024-01-01 - 2024-31-12");
	    leavePage.clickGenerate();
	    leavePage.verifyRecordsFound("(11) Records Found");			        
}
			        
	  @Test(priority = 9)
		public void ConfigureLeavePeriod() {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		leavePage.selectConfigureLabel("Leave Period");
	    leavePage.selectStartMonth("January");
	    leavePage.selectStartDate("07");
		leavePage.clickSave(); 
		leavePage.verifySuccessMessage("Successfully Saved");				        
}
	  @Test(priority = 10)
		public void ConfigureLeaveType() {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		
		leavePage.selectConfigureLabel("Leave Types");

		leavePage.clickEdit();

	    leavePage.editLeaveTypeName("CAN - Annual Leave");
	    leavePage.clickSave(); 
		leavePage.verifySuccessMessage("Successfully Updated");

	  }
	  @Test(priority = 11)
		public void ConfigureWorkWeek() {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		leavePage.selectConfigureLabel("Work Week"); 
	    leavePage.selectMonday("Half Day");
	    leavePage.selectTuesday("Half Day");
	    leavePage.selectWednesday("Half Day");
	    leavePage.selectThursday("Half Day");
	    leavePage.selectFriday("Half Day");
	    leavePage.selectSaturday("Half Day");
	    leavePage.selectSunday("Half Day");
	    leavePage.clickSave(); 
		leavePage.verifySuccessMessage("Successfully Saved");
 }
	  @Test(priority = 12)
		public void ConfigureHolidays() {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		leavePage.selectConfigureLabel("Holidays");
		leavePage.enterFromAndToDates("2025-03-16", "2025-03-16");
		leavePage.clickSearch();
	    leavePage.verifyRecords("(1) Record Found");

}
	  @Test(priority = 13)
		public void LeaveList() {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		leavePage.clickLeaveList();
		leavePage.enterFromAndToDates("2025-03-16", "2025-03-16");
		leavePage.selectLeaveType("CAN - Personal");
	    leavePage.selectSubUnit("Administration");
		leavePage.clickSearch();
		leavePage.verifySuccessMessage("No Records Found");

 }
	  @Test(priority = 14)
		public void AssignLeave() {
					        
		loginPage.login("Admin", "admin123");

		leavePage.clickLeaveMenu();
		leavePage.AssignLeave();
        leavePage.enterEmployeeName("Ranga  Akunuri");
		leavePage.selectLeaveType("CAN - Personal");
		leavePage.enterFromAndToDates("2025-20-11", "2025-25-11");
		leavePage.clickAssign();
		leavePage.clickOkButton();
		leavePage.verifySuccessMessage("Successfully Saved");

  }
}
