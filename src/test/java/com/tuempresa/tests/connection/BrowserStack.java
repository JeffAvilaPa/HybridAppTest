package com.tuempresa.tests.connection;

import com.tuempresa.config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

public class BrowserStack {

    ConfigReader config = new ConfigReader();

    @Test
    public void testBrowserStackConnection() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", config.get("platformName"));
        caps.setCapability("deviceName", config.get("deviceName"));
        caps.setCapability("platformVersion", config.get("platformVersion"));
        caps.setCapability("app", config.get("app"));
        caps.setCapability("browserstack.user", config.get("browserstack.user"));
        caps.setCapability("browserstack.key", config.get("browserstack.key"));
        caps.setCapability("project", config.get("project"));
        caps.setCapability("build", config.get("build"));
        caps.setCapability("name", config.get("name"));

        String user = config.get("browserstack.user");
        String key = config.get("browserstack.key");
        String remoteUrl = "https://" + user + ":" + key + "@hub.browserstack.com/wd/hub";

        System.out.println("url: " + remoteUrl);

        AppiumDriver driver = new AppiumDriver(new URL(remoteUrl), caps);

        System.out.println("✅ Conexión exitosa a BrowserStack.");
        driver.quit();
    }
}
