package org.stepdefinition;


import org.bas.BaseClass;
import org.bas.FlipKartLoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartLogin extends BaseClass{
	
	@Given("To launch the chrome brower and minimise window")
	public void to_launch_the_chrome_brower_and_minimise_window() {
	   launchBrowser();
	   windowMaximize();
	}

	@When("To launch the url of flipkart application")
	public void to_launch_the_url_of_flipkart_application() {
		launchUrl("https://affiliate.flipkart.com/login");
	}
	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		FlipKartLoginPojo fk = new FlipKartLoginPojo();
		passText("ubendranmannan007@gmail.com", fk.getEmail());
	}

	@When("To pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field() {
		FlipKartLoginPojo fk = new FlipKartLoginPojo();
		passText("12345", fk.getPassword());
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		FlipKartLoginPojo fk = new FlipKartLoginPojo();
	    clickBtn(fk.getLogin());
	}

	@When("To check whether navigate to the home page or not")
	public void to_check_whether_navigate_to_the_home_page_or_not() {
	System.out.println("To check your login credentials");
		
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	    closeEntireBrowser();
	}


}
