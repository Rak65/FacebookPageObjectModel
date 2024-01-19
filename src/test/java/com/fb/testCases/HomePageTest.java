package com.fb.testCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.base.BaseClass;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;

public class HomePageTest extends BaseClass{
    LoginPage loginPage;
    HomePage homePage;
    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginFb(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority=1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Facebook");
    }

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}