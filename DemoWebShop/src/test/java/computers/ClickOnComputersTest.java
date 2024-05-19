package computers;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;

public class ClickOnComputersTest extends BaseClass {
	@Test
	public void clickOnComputers() throws FileNotFoundException
	{
		hp.getcomputersLink().click();
		String expectedTitleComp = eLib.getDataFromExcel("Computers", 1,0 );
		Assert.assertEquals(driver.getTitle(),expectedTitleComp, "Computers Page not displayed");
		test.log(Status.PASS, "Computers Page Displayed Successfully");
	}
}
