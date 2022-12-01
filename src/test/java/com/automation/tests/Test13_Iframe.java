package com.automation.tests;

import com.automation.pages.IframePage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test13_Iframe {
    /**
     * Test switches to Iframe and types some text.
     * Test asserts that the typed text is as expected.
     */

    @Test
    public void iframeTest(){
        IframePage iframePage = new IframePage();

        String url = ConfigurationReader.getProperty("base.url") + "/iframe";
        Driver.getDriver().get(url);

        Driver.getDriver().switchTo().frame(iframePage.iframe);
        String text = "some text";
        iframePage.textBox.clear();
        iframePage.textBox.sendKeys(text);
        Assert.assertEquals(iframePage.textBox.getText(), text);

        Driver.closeDriver();

    }

}
