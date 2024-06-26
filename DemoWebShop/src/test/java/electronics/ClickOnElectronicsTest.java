package electronics;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class ClickOnElectronicsTest extends BaseClass {
	@Test
	public void clickOnElectronics() throws FileNotFoundException
	{
		hp.getelectronicsLink().click();
		String expectedTitleElectonics = eLib.getDataFromExcel("Electronics", 1,0 );
		Assert.assertEquals(driver.getTitle(),expectedTitleElectonics, "Electronics Page not displayed");
		test.log(Status.PASS, "Electronics Page Displayed Successfully");
	}
}
