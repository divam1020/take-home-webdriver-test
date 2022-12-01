package com.automation.tests;

import com.automation.pages.FloatingMenuPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test12_FloatingMenu {
    @Test
    public void floatingMenuTest() throws AWTException, InterruptedException {

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

        String url = ConfigurationReader.getProperty("base.url") + "/floating_menu";
        Driver.getDriver().get(url);
        Thread.sleep(4000);
        Robot rb = new Robot();

        rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyRelease(KeyEvent.VK_PAGE_DOWN);

		Assert.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());
        Driver.closeDriver();
    }

}
