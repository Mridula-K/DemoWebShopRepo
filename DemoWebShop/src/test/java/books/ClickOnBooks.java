package books;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class ClickOnBooks extends BaseClass{
@Test
public void clickOnBooks() throws FileNotFoundException
{
	hp.getbooksLink().click();
	String expectedTitleBooks = eLib.getDataFromExcel("Books", 1,0 );
	Assert.assertEquals(driver.getTitle(),expectedTitleBooks, "Books Page not displayed");
	test.log(Status.PASS, "Books Page Displayed Successfully");
}
}
