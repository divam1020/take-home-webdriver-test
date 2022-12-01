package com.automation.tests;

import com.automation.pages.DynamicLoadingPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test09_DynamicLoading {
    /**
     * Test clicks the start button and uses explicit wait.
     * Test asserts that â€œHello World!â€� text is displayed.
     */

    @Test
    public void dynamicLoadingTest() {

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dynamic_loading/2";
        Driver.getDriver().get(url);

        dynamicLoadingPage.startBtn.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadingPage.loading));

        Assert.assertEquals(dynamicLoadingPage.displayedText.getText(),"Hello World!");

        Driver.closeDriver();
    }

}
