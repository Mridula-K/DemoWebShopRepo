package login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;

public class TC_DWS_002_Test extends BaseClass{
@Test
public void login()
{
	wp.getLoginLink().click();;
	lp.getEmailTF().sendKeys("saibaba7166@gmail.com");
	lp.getPwdTF().sendKeys("Sb23@1947");
	lp.getLoginBtn().sendKeys(Keys.ENTER);
	WebElement Books = hp.getbooksLink();
	Assert.assertEquals(Books.isDisplayed(), true,"Home Page not displayed");
	test.log(Status.PASS, "Login Successful...Home Page displayed..");
	Reporter.log("HP displayed...Login successful...",true);
}
}
