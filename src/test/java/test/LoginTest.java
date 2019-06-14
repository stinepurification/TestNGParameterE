package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	@Test
	@Parameters({"email","password"})
	public void loginTest(String email, String password) {
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=login/");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);	
		loginPage.userLogsIn("techfiosdemo@gmail.com", "abc123");
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.waitForPage();

		driver.close();
		driver.quit();
	}
}