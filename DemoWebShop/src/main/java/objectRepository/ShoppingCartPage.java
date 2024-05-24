package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "//h1[text()='Shopping cart']")
	private WebElement shoppingCartText;
	
	@FindBy(name = "removefromcart")
	private WebElement removeFromCart;
	
	@FindBy(name = "updatecart")
	private WebElement updateCartBtn;
	
	@FindBy(xpath = "//div[@class='order-summary-content']")
	private WebElement shoppingCartEmptyMsg;
	

	public WebElement getShoppingCartEmptyMsg()
	{
		return shoppingCartEmptyMsg;
	}
	
	
	public WebElement getShoppingCartText()
	{
		return shoppingCartText;
	}
	
	public WebElement getRemoveFromCartCB()
	{
		return removeFromCart;
	}
	
	public WebElement getupdateCartBtn()
	{
		return updateCartBtn;
	}
	
}
