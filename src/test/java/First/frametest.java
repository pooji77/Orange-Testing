package First;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseFrameTest;
import pages.Framepage;

public class frametest extends BaseFrameTest{
	Framepage framePage;
    
    @BeforeMethod
    public void setUpPages() {
        framePage = new Framepage(driver);
        
    }
	@Test
    public void testFrames() {
		framePage.closeAd();
        framePage.scrollIntoView(framePage.getFramePage());
        framePage.clickFramesPage();
        framePage.frame();        
        
        System.out.println("Frame 1 text: " + framePage.getFrame1Text());       
    }
	
	 @Test(priority=1)
	    public void testNestedFrames() {
		 framePage.closeAd();
	        framePage.scrollIntoView(framePage.getFramePage());
	        framePage.clickFramesPage();

	        framePage.nestedframe(); 

	        System.out.println("Parent Frame: " + framePage.getParentFrameText());
	        System.out.println("Child Frame: " + framePage.getChildFrameText());
	    }
}
