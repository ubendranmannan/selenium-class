package org.bas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPojo extends BaseClass {

	public GmailLoginPojo(){
	PageFactory.initElements(driver, this);
	}
	@FindBy(id="inputEmail")
	private WebElement email;
	
    @FindBy(id="inputPassword")
    private WebElement password;

    @FindBy(id="submitLogin")
    private WebElement login;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

}
