package com.fb.pages;

public class HomePage extends LoginPage {
    public String verifyHomePageTitle(){
        return webDriver.getTitle();
    }

}