package register;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import genericUtility.BaseClass;

public class RegisterTest extends BaseClass {
	@Test
	public void register() {
		wp.getRegisterLink().click();
		rp.getFirstNameTF().sendKeys("Sai");
		rp.getLastNameTF().sendKeys("baba");
		rp.getMaleRB().click();
		rp.getEmailTF().sendKeys(Keys.chord("saibaba@gmail.com"));
		rp.getPwdTF().sendKeys("Sb23@1932");
		rp.getConfirmPwdTF().sendKeys("Sb23@1932");
		rp.getRegisterBtn().sendKeys(Keys.ENTER);
	}
}
