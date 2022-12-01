package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test02_LoginFailure {

    @Test
    public void loginWithWrongPasswordTest() {
        LoginPage loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("base.url") + "/login";
        Driver.getDriver().get(url);

        loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys("WRONGpassword");
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.resultMsg.getText().contains("Your password is invalid!"));

        Driver.closeDriver();

    }

}
