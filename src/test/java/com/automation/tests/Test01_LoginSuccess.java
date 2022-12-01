package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_LoginSuccess {

    /**
     * Page Object Model for the login page should be provided.
     * Test is able to login successfully.
     * Test uses an assertion to make sure User has logged in.
     */

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("base.url") + "/login";
        Driver.getDriver().get(url);

        loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.resultMsg.getText().contains("You logged into a secure area!"));

        Driver.closeDriver();

    }

}
