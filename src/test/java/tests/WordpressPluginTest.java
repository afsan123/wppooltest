package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AdminHomePage;
import pageobjects.FrontendPage;
import pageobjects.LoginPage;
import pageobjects.WPdarkModePage;
import utility.ConfigReader;

public class WordpressPluginTest extends BaseClass{

    @Test
    public void testCase() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Login Page Not Displayed");

        loginPage.enterUsername(ConfigReader.getUsername());
        loginPage.enterPassword(ConfigReader.getPassword());
        loginPage.clickOnLoginBtn();

        AdminHomePage adminHomePage = new AdminHomePage();
        Assert.assertTrue(adminHomePage.state().waitForDisplayed(), "Login Page Not Displayed");

        adminHomePage.clickOnWPpageButton();

        WPdarkModePage wPdarkModePage = new WPdarkModePage();
        Assert.assertTrue(wPdarkModePage.state().waitForDisplayed(), "WPdarkModePage didn't open");

        wPdarkModePage.clickOnbackendElementDarkMode();
        wPdarkModePage.clickOnDashboardBtn();
        Assert.assertTrue(wPdarkModePage.checkWPDarkModeWorkingOrNot(), "WP Dark Mode Not Working");

        adminHomePage.clickOnWPpageButton();
        wPdarkModePage.clickOnSwitchSettings();
        wPdarkModePage.selctFloatingStyle();
        wPdarkModePage.clickOnSwitchPosition();
        wPdarkModePage.selectSwitchPosition();
        Assert.assertTrue(wPdarkModePage.isLeftBottomSelected(), "Left Bottom is not selected");
        wPdarkModePage.navigateToAccessibilitySetting();
        wPdarkModePage.disableKeyboardShortcut();
        wPdarkModePage.navigateToAnimationSettings();
        wPdarkModePage.enableDarkmodeToggleAnimation();
        wPdarkModePage.selectAnimationEffect("fade");
        wPdarkModePage.saveSettings();

        FrontendPage frontendPage = new FrontendPage();

        frontendPage.navigateToFrontend();

        Assert.assertTrue(frontendPage.validateDarkMode(), "WP Dark Mode not Working.");
    }
}
