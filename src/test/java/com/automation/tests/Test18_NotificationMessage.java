package com.automation.tests;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test18_NotificationMessage {
    @Test
    public void notificationMessageTest() throws InterruptedException{
        String url = ConfigurationReader.getProperty("base.url") + "/notification_message_rendered";
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.linkText("Click here")).click();
        Thread.sleep(1000);
		String msg = Driver.getDriver().getPageSource();
		if (msg.contains("Action unsuccesful, please try again") || msg.contains("Action successful")
				|| msg.contains("Action Unsuccessful"))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

        Driver.closeDriver();
    }
}
