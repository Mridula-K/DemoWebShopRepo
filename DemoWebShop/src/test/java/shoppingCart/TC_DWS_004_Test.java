package shoppingCart;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;

public class TC_DWS_004_Test extends BaseClass
{
@Test
public void removeProduct()
{
	hp.getShoppingCartLink().click();
	sp.getRemoveFromCartCB().click();
	
	sp.getupdateCartBtn().click();
	WebElement emptyMsg = sp.getShoppingCartEmptyMsg();
	Assert.assertEquals(emptyMsg.isDisplayed(),true,"Shopping cart is not emptied");
	test.log(Status.PASS, "Shopping Cart is Empty Successfully..!");
}
}
