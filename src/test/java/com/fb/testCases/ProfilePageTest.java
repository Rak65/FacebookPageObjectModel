package com.fb.testCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fb.base.BaseClass;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;
import com.fb.pages.ProfilePage;

public class ProfilePageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    public ProfilePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginFb(properties.getProperty("username"), properties.getProperty("password"));
        profilePage = new ProfilePage();
    }

    @Test(priority=1)
    public void verifyProfilePageTest() {
        profilePage = profilePage.clickOnprofilePage();
    }

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}