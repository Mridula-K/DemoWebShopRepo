package genericUtility;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	public Actions act;
	public WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
     act=new Actions(driver);
     this.driver=driver;
     
	}
	
	public void doubleClick(WebElement element)
	{
		act.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebElement source,WebElement target)
	{
		act.dragAndDrop(source, target).perform();
	}
	
	public void mouseHoverOnElement(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	
	public void switchToWindow(String urlOfWindow)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
	
		for(String id:allWindowIds) {
			String url=driver.switchTo().window(id).getCurrentUrl();
			if(url.equals(urlOfWindow)) {
				break;
			}
		}
	}
			
	public void switchToFrame(int indexNum)
	{
		driver.switchTo().frame(indexNum);
	}
	
	public void switchToFrame(String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public Alert switchToAlert()
	{
		return driver.switchTo().alert();
	}

	
}
