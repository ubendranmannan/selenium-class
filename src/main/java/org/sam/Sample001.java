package org.sam;

import org.bas.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sample001 extends BaseClass{
   private void tv1() {
	launchBrowser();
	windowMaximize();
	launchUrl("https://accounts.google.com/signin");
	WebElement cl=driver.findElement(By.id("identifierId"));
	cl.sendKeys("7200100864");
	WebElement cl1=driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[2]"));
	cl1.click();

}
	
}
