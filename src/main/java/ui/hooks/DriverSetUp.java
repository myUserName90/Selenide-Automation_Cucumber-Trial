package ui.hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DriverSetUp {

    private static final String websiteUrl = "http://spring-backoffice-st.betconstruct.int/";

    @Before
    public void openBrowser() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.acceptInsecureCerts();
        capabilities.setAcceptInsecureCerts(true);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .includeSelenideSteps(false)
                .savePageSource(false));
        browser = CHROME;
        pageLoadStrategy = "eager";
        holdBrowserOpen = false;
        savePageSource = false;
        pollingInterval = 800;
        startMaximized = true;
        baseUrl = websiteUrl;
        fastSetValue = true;
        screenshots = false;
        headless = false;
        timeout = 25000;

        remote = "http://10.25.112.102:4444/wd/hub";
        driverManagerEnabled = false;
        browserCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));

        browserCapabilities.merge(capabilities);
        open();
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

}
