package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	WebDriver driver;

	public DashboardPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'CRM')]")
	WebElement CRM;
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Add Contact')]")
	WebElement AddContact;
	@FindBy(how = How.NAME, using = "name")
	WebElement SearchCustomer;

	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void NavigateToAddContactPage() {
		CRM.click();
		AddContact.click();
	}

	public void VerifyPageLogin() {
		CRM.isDisplayed();
		SearchCustomer.isDisplayed();
	}
}