package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.CommonDropdown;
import utils.Dropdown;
import utils.NotificationUtils;
import utils.WaitUtils;

public class Leavepage {
	private WebDriver driver;

    @FindBy(xpath = "//a[.='Leave']")
     WebElement leaveMenu;
    
    @FindBy(css = ".oxd-text--h6")
    WebElement leaveHeader;

    @FindBy(xpath = "//a[.='Apply']")
    WebElement applyLabel;
    
    @FindBy(xpath = "//a[.='My Leave']")
    WebElement myleaveLabel;
   
    @FindBy(xpath = "//*[normalize-space()='Entitlements']")
    WebElement EntitlementsLabel;
    
    @FindBy(xpath = "//a[.='Add Entitlements']")
    WebElement addEntitlementsLabel;
    
    @FindBy(xpath = "//a[.='Employee Entitlements']")
    WebElement employeeEntitlementsLabel;
    
    @FindBy(xpath = "//a[.='My Entitlements']")
    WebElement myEntitlementsLabel;
  
    @FindBy(xpath = "//li[contains(.,'Reports')]")
    WebElement reportsLabel;
    
    @FindBy(xpath = "//a[.='Leave Entitlements and Usage Report']")
    WebElement leaveLabel;
    
    @FindBy(xpath = "//a[.='My Leave Entitlements and Usage Report']")
    WebElement myLabel;
    
    @FindBy(xpath = "//li[contains(.,'Configure')]")
    WebElement configureLabel;
    
    @FindBy(xpath = "//a[.='Leave Period']")
    WebElement leaveperiodLabel;
    
    @FindBy(xpath = "//a[.='Leave Types']")
    WebElement leavetypesLabel;
    
    @FindBy(xpath = "//a[.='Work Week']")
    WebElement workweekLabel;
    
    @FindBy(xpath = "//a[.='Holidays']")
    WebElement holidaysLabel;
    
    @FindBy(xpath = "//li[.='Leave List']")
    WebElement leavelistLabel;
    
    @FindBy(xpath = "//a[.='Assign Leave']")
    WebElement assignleaveLabel;
    
    @FindBy(css = ".oxd-text--subtitle-2")
    WebElement ApplyMessage;
    
    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    WebElement fromDateInput;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
    WebElement toDateInput;

    @FindBy(xpath = "(//i[contains(@class,'bi-calendar')])[1]")
    WebElement fromDateIcon;

    @FindBy(xpath = "(//i[contains(@class,'bi-calendar')])[2]")
    WebElement toDateIcon;
    
    @FindBy(css = ".oxd-button--secondary")
    WebElement SearchButton;

    @FindBy(css = ".oxd-toast")
    WebElement successPopup;
      
    @FindBy(css = ".oxd-button")
    WebElement generateButton;
    
    @FindBy(css = ".oxd-text--count")
    WebElement recordsFoundLabel;

    @FindBy(css = ".oxd-button--secondary")
    WebElement SaveButton;
    
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement recordsFound;

    @FindBy(css = ".oxd-button")
    WebElement AssignButton;
    
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameInput;
    
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> employeeSuggestions;
    
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin']")
    WebElement OkButton;
 
    @FindBy(xpath = "(//div[@class='oxd-table-body']//button[i[contains(@class,'bi-pencil-fill')]])[1]")
    WebElement editButton;
    
    @FindBy(xpath = "//label[contains(text(),'Name')]/ancestor::div[contains(@class,'oxd-input-group')]/div[2]//input")
    WebElement leaveTypeName;    
    
    @FindBy(xpath = "//form[@class='oxd-form']//input[@class='oxd-input oxd-input--active']")
    WebElement Entitlement;
    
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin']")
    WebElement confirmButton;
    
    @FindBy(css = ".orangehrm-left-space")
    WebElement Search;

    public Leavepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickLeaveMenu() {
        WaitUtils.waitForVisibility(driver, leaveMenu, 30);
        leaveMenu.click();
    }
    public void clickConfirm() {
        WaitUtils.waitForVisibility(driver, confirmButton, 30);
        confirmButton.click();
    }
    public void clickEdit() {
        WaitUtils.waitForVisibility(driver, editButton, 30);
        editButton.click();
    }
    public void Entitlement(String entitlement) {
	    
    	WaitUtils.waitForVisibility(driver,Entitlement,30);
        Entitlement.sendKeys(entitlement);
    }
    public void clickOkButton() {
        WaitUtils.waitForVisibility(driver, OkButton, 30);
        OkButton.click();
    }
    public void clickLeaveList() {
        WaitUtils.waitForVisibility(driver, leavelistLabel, 30);
        leavelistLabel.click();
    }
    public boolean isLeavePageDisplayed() {
        return WaitUtils.waitForVisibility(driver, leaveHeader, 30).isDisplayed();
    }
    
    public void ApplyPage() {
        WaitUtils.waitForVisibility(driver, applyLabel, 20);
        applyLabel.click();
        System.out.println("Clicked on Apply Leave menu item.");
    }
    public void LeavePage() {
        WaitUtils.waitForVisibility(driver, myleaveLabel, 20);
        myleaveLabel.click();
        System.out.println("Clicked on MyLeave menu item.");
    }
    public void editLeaveTypeName(String newName) {
        WaitUtils.waitForVisibility(driver, leaveTypeName, 20);
        Actions actions = new Actions(driver);

        actions.click(leaveTypeName).perform();
        
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        actions.sendKeys(Keys.DELETE).perform();

        actions.sendKeys(newName).perform();
    }

    
    public void validateLeaveModule() {
    	
        WaitUtils.waitForVisibility(driver, applyLabel, 30);

        Assert.assertTrue(applyLabel.isDisplayed(), "Apply Label field not visible");
        Assert.assertTrue(myleaveLabel.isDisplayed(), "My Leave Label field not visible");
        Assert.assertTrue(EntitlementsLabel.isDisplayed(), "Entitlements Label not visible");   
        Assert.assertTrue(reportsLabel.isDisplayed(), "Reports Label not visible");
        Assert.assertTrue(configureLabel.isDisplayed(), "Configure Label not visible");
        Assert.assertTrue(leavelistLabel.isDisplayed(), "Leave list Label not visible");
        Assert.assertTrue(assignleaveLabel.isDisplayed(), "Assign leave Label not visible");
        System.out.println("All Leave Page UI elements verified successfully.");
    	
    }
    
    public void validateDropdownLabels() throws InterruptedException {
    	WaitUtils.waitForVisibility(driver, EntitlementsLabel, 30);

        Assert.assertTrue(EntitlementsLabel.isDisplayed(), "Entitlements Label not visible before clicking.");

        EntitlementsLabel.click();
        System.out.println("Clicked Entitlements dropdown.");
        
        WaitUtils.waitForVisibility(driver, addEntitlementsLabel, 20);
        Assert.assertTrue(addEntitlementsLabel.isDisplayed(), "Add Entitlements not visible");
        Assert.assertTrue(employeeEntitlementsLabel.isDisplayed(), "Employee Entitlements not visible");
        Assert.assertTrue(myEntitlementsLabel.isDisplayed(), "My Entitlements not visible");
        EntitlementsLabel.click(); 

        reportsLabel.click();
        WaitUtils.waitForVisibility(driver, leaveLabel, 20);
        Assert.assertTrue(leaveLabel.isDisplayed(), "Leave Entitlements Report not visible");
        Assert.assertTrue(myLabel.isDisplayed(), "My Leave Entitlements Report not visible");
        reportsLabel.click();

        configureLabel.click();
        WaitUtils.waitForVisibility(driver, leaveperiodLabel, 20);
        Assert.assertTrue(leaveperiodLabel.isDisplayed(), "Leave Period not visible");
        Assert.assertTrue(leavetypesLabel.isDisplayed(), "Leave Types not visible");
        Assert.assertTrue(workweekLabel.isDisplayed(), "Work Week not visible");
        Assert.assertTrue(holidaysLabel.isDisplayed(), "Holidays not visible");
        configureLabel.click();

        System.out.println("All dropdown items verified successfully.");
    }
    public void selectLabel(String label) {
        Dropdown.selectMenu(driver, "Entitlements", label);
    }
    public void selectReportsLabel(String label) {
        Dropdown.selectMenu(driver, "Reports", label);
    }
    public void selectConfigureLabel(String label) {
        Dropdown.selectMenu(driver, "Configure", label);
    }
    
    public void verifyApplyMessage() {
        WaitUtils.waitForVisibility(driver, ApplyMessage, 30);
        String actualMessage = ApplyMessage.getText();
        String expectedMessage = "No Leave Types with Leave Balance";
        Assert.assertEquals(actualMessage.trim(), expectedMessage, "Message mismatch!");
        
        System.out.println("Verified message: " + actualMessage);
    }
    
    public void enterFromAndToDates(String from, String to) {
        WaitUtils.waitForVisibility(driver, fromDateInput, 30).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        fromDateInput.sendKeys(from);

        WaitUtils.waitForVisibility(driver, toDateInput, 30).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        toDateInput.sendKeys(to);
    }
    
    public void selectLeaveType(String Leavetype) {
        CommonDropdown.selectDropdown(driver, "Leave Type", Leavetype);
    }
    public void selectLeavePeriod(String Leaveperiod) {
        CommonDropdown.selectDropdown(driver, "Leave Period", Leaveperiod);
    }
    public void selectLocation(String Location) {
        CommonDropdown.selectDropdown(driver, "Location", Location);
    }
    public void selectSubUnit(String Subunit) {
        CommonDropdown.selectDropdown(driver, "Sub Unit", Subunit);
    }
    public void selectJobTitle(String JobTitle) {
        CommonDropdown.selectDropdown(driver, "Job Title", JobTitle);
    }
    public void selectStartMonth(String StartMonth) {
        CommonDropdown.selectDropdown(driver, "Start Month", StartMonth);
    }
    public void selectStartDate(String StartDate) {
        CommonDropdown.selectDropdown(driver, "Start Date", StartDate);
    }
    public void selectMonday(String Monday) {
        CommonDropdown.selectDropdown(driver, "Monday", Monday);
    }
    public void selectTuesday(String Tuesday) {
        CommonDropdown.selectDropdown(driver, "Tuesday", Tuesday);
    }
    public void selectWednesday(String Wednesday) {
        CommonDropdown.selectDropdown(driver, "Wednesday", Wednesday);
    }
    public void selectThursday(String Thursday) {
        CommonDropdown.selectDropdown(driver, "Thursday", Thursday);
    }
    public void selectFriday(String Friday) {
        CommonDropdown.selectDropdown(driver, "Friday", Friday);
    }
    public void selectSaturday(String Saturday) {
        CommonDropdown.selectDropdown(driver, "Saturday", Saturday);
    }
    public void selectSunday(String Sunday) {
        CommonDropdown.selectDropdown(driver, "Sunday", Sunday);
    }
    public void clickSearch() {
        WaitUtils.waitForVisibility(driver, SearchButton, 20);
        SearchButton.click();     
    }
    public void clickSave() {
        WaitUtils.waitForVisibility(driver, SaveButton, 20);
        SaveButton.click();     
    }
    
    public void verifySuccessMessage(String message) {
        NotificationUtils.verifySuccessNotification(driver, message);
    }

    public void clickGenerate() {
        WaitUtils.waitForVisibility(driver, generateButton, 30);
        generateButton.click();
    }	
    public void clickAssign() {
        WaitUtils.waitForVisibility(driver, AssignButton, 20);
        AssignButton.click();
    }
	
	public void AssignLeave() {
        WaitUtils.waitForVisibility(driver, assignleaveLabel, 20);
        assignleaveLabel.click();
    }
    public void verifyRecordsFound(String expectedText) {
        WebElement element = WaitUtils.waitForVisibility(driver, recordsFoundLabel, 10);
        String actualText = element.getText().trim();
        System.out.println("Actual Records Text: " + actualText);

        Assert.assertTrue(actualText.contains(expectedText),
                "Expected text not found! Actual: " + actualText);
    }
    public void verifyRecords(String expectedText) {
        WebElement element = WaitUtils.waitForVisibility(driver, recordsFound, 30);
        String actualText = element.getText().trim();
        System.out.println("Actual Records Text: " + actualText);
        Assert.assertEquals(actualText, expectedText, "Record Found text does not match!");
    }
    public void enterEmployeeName(String empName) {
        WebElement input = WaitUtils.waitForVisibility(driver, employeeNameInput, 10);
        input.clear();
        input.sendKeys(empName.substring(0, 3));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> employeeSuggestions.size() > 0);

        WebElement first = WaitUtils.waitForVisibility(driver, employeeSuggestions.get(0), 10);

        employeeSuggestions.stream()
                .filter(e -> e.getText().trim().equalsIgnoreCase(empName))
                .findFirst()
                .orElse(first)
                .click();

        System.out.println("Entered Employee Name: " + empName);
    }

}



