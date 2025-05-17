package com.tuempresa.base;

import com.tuempresa.config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AppiumDriver driver;
    protected WebDriverWait wait;
    ConfigReader config = new ConfigReader();

    @BeforeClass
    public void setUp() throws MalformedURLException {
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

        System.out.println("🔗 URL: " + remoteUrl);

        // Inicializar el driver (usa el atributo global ahora)
        driver = new AppiumDriver(new URL(remoteUrl), caps);

        // Espera global para elementos
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Esperar hasta que aparezca el texto de la pantalla principal
        WebElement mainTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='Tab 1 page']"))
        );

        System.out.println("✅ App cargada correctamente, visible: " + mainTab.getText());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🛑 Sesión cerrada.");
        }
    }
}
