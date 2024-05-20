package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage 
{
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(id = "gender-male")
private WebElement maleRadioBtn;

@FindBy(id = "gender-female")
private WebElement femaleRadioBtn;

@FindBy(id = "FirstName")
private WebElement firstNameTF;

@FindBy(id = "LastName")
private WebElement lastNameTF;

@FindBy(id = "Email")
private WebElement emailTF;

@FindBy(id = "Password")
private WebElement pwdTF;

@FindBy(id = "ConfirmPassword")
private WebElement confirmPwdTF;

@FindBy(id = "register-button")
private WebElement registerBtn;

public WebElement getMaleRB()
{
	return maleRadioBtn;
}

 public WebElement getFemaleRB()
 {
	 return femaleRadioBtn;
 }
 
 public WebElement getFirstNameTF()
 {
	 return firstNameTF;
 }
 
 public WebElement getLastNameTF()
 {
	 return lastNameTF;
 }
 
 public WebElement getEmailTF()
 {
	return emailTF;	 
 }
 
 public WebElement getPwdTF()
 {
	 return pwdTF;
 }
 
 public WebElement getConfirmPwdTF()
 {
	 return confirmPwdTF;
 }
 
 public WebElement getRegisterBtn()
 {
	 return registerBtn;
 }



}
