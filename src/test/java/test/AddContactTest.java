package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {
	
	@Test
	@Parameters({"userName", "password", "name", "company", "email", "phone", "address", "city", "state", "zip", "country"})
	public void usersCanAddContact(String userName, String password, String name, String company, String email, String phone, String address, String city, String state, String zip, String country) throws InterruptedException {
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=login/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);	
		loginPage.userLogsIn(userName, password);
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.waitForPage();
		dashboardPage.NavigateToAddContactPage();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.FillTheAddressForm(name, company, email, phone, address, city, state, zip, country);
		
		driver.close();
		driver.quit();
	}
}