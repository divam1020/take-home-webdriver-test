package com.automation.tests;

import com.automation.pages.FileUploadPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test11_FileUpload {
    /**
     * Test uses Upload Button or Drag and Drop to upload a file.
     * Test asserts that the file is uploaded.
     * @throws InterruptedException 
     */

    //TODO change "file.path" and/or "file.name" to file you want to upload in configuration.properties if needed

    @Test
    public void fileUploadButtonTest() throws InterruptedException {

        FileUploadPage fileUploadPage = new FileUploadPage();

        String url = ConfigurationReader.getProperty("base.url") + "/upload";
        Driver.getDriver().get(url);
        Thread.sleep(3000);
        String filePath = System.getProperty("user.dir") + File.separator + "downloadFiles" + File.separator + "some-file.txt";
        fileUploadPage.chooseFile.sendKeys(filePath);
        fileUploadPage.uploadBtn.click();

        Assert.assertEquals(fileUploadPage.message.getText(), "File Uploaded!");

        Driver.closeDriver();
    }

}
