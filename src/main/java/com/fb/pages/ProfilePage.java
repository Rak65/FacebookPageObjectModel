package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends HomePage{
    @FindBy(xpath = "//div[@class='x78zum5 x1n2onr6']")
    WebElement profilePage;

    public ProfilePage clickOnprofilePage(){
        profilePage.click();
        return new ProfilePage();
    }
}
