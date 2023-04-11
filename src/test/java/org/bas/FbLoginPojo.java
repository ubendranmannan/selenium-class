package org.bas;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPojo  extends BaseClass{
	public FbLoginPojo(){
	PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement email;
	
    @FindBy(id="pass")
    private WebElement password;

    @FindBy(name="login")
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