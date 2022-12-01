package com.automation.tests;

import com.automation.pages.DynamicContentPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test07_DynamicContent {
    /**
     * Test refreshes the page a couple of times.
     * Test asserts that the content changes on each refresh.
     */

    @Test
    public void dynamicContentTest() {

        DynamicContentPage dynamicContentPage = new DynamicContentPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dynamic_content";
        Driver.getDriver().get(url);

        String textBeforeRefresh = dynamicContentPage.content.getText();
        //System.out.println(textBeforeRefresh);

        Driver.getDriver().navigate().refresh();

        String textAfterFirstRefresh = dynamicContentPage.content.getText();
        //System.out.println(textAfterRefresh);

        Assert.assertNotEquals(textAfterFirstRefresh, textBeforeRefresh);

        Driver.getDriver().navigate().refresh();

        String textAfterSecondRefresh = dynamicContentPage.content.getText();

        Assert.assertNotEquals(textAfterSecondRefresh, textAfterFirstRefresh);

        Driver.closeDriver();
    }

}
