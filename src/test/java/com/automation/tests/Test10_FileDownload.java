package com.automation.tests;

import com.automation.pages.DownloadPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class Test10_FileDownload {
    @Test
    public void fileDownloadTest() throws InterruptedException {

        DownloadPage downloadPage = new DownloadPage();

        String url = ConfigurationReader.getProperty("base.url") + "/download";
        Driver.getDriver().get(url);

        downloadPage.file.click();
        
        Thread.sleep(2000);
		File file = new File(System.getProperty("user.dir") + File.separator + "downloadFiles" + File.separator + "some-file.txt");
		Assert.assertTrue(file.exists());
		
        Driver.closeDriver();

    }

}
