package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log out")
	private WebElement logoutLink;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> addtoCartBtns;
	
	@FindBy(xpath = "//p[contains(text(),'The product has been added')]")
	private WebElement productAddedMsg;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement computersLink;
	
	public WebElement getbooksLink()
	{
		return booksLink;
	}
	
	
	
	public WebElement getcomputersLink()
	{
		return computersLink;
	}
	
	
	public WebElement getelectronicsLink()
	{
		return electronicsLink;
	}
	public WebElement getProductAddedMsg()
	{
		return productAddedMsg;
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public List<WebElement> getaddtoCartBtns()
	{
		return addtoCartBtns;
	}
    
	
}
