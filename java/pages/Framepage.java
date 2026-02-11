package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class Framepage {
	private WebDriver driver;

    @FindBy(css = "[viewBox='0 0 14 16']")
	public
     WebElement framePage;
    
    @FindBy(xpath = "//span[.='Frames']")
    WebElement frame;
   
    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedframe;
    
    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "sampleHeading")
    WebElement heading;
    
    @FindBy(css = "iframe[srcdoc*='Parent frame']")
    WebElement parentFrame;

    public Framepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFramesPage() {
        WaitUtils.waitForVisibility(driver, framePage, 30);
        framePage.click();
    }

    public void frame() {
    	WaitUtils.waitForVisibility(driver, frame, 30);
        frame.click();
    }

    public void nestedframe() {
    	WaitUtils.waitForVisibility(driver, nestedframe, 30);
        nestedframe.click();
    }
    
    public WebElement getFramePage() {
        return framePage;
    }
    
    public void closeAd() {
        try {
            WebElement ad = driver.findElement(By.id("fixedban"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", ad);
        } catch (Exception e) {
            
        }
    }


    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public String getFrame1Text() {
        driver.switchTo().frame(frame1);
        String text = heading.getText();
        driver.switchTo().defaultContent();
        return text;
    }
   
    public String getParentFrameText() {
        driver.switchTo().frame(parentFrame);
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getChildFrameText() {
        driver.switchTo().frame(parentFrame);    

        WaitUtils.waitForFrameAndSwitchToIt(driver, 0, 30);

        String text = driver.findElement(By.tagName("p")).getText();

        driver.switchTo().defaultContent();
        return text;
    }
}
