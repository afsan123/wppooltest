package pageobjects;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WPdarkModePage extends Form {
    private final IButton backendElementDarkMode = getElementFactory().getButton(By.xpath("//div[@class='wp-dark-mode-ignore']/label[@for='wppool-wp_dark_mode_general[enable_backend]']"), "Enable Backend Dark Mode");
    private final ILabel darkModeSwitch = getElementFactory().getLabel(By.xpath("//input[@type='checkbox' and @name='wp_dark_mode_general[enable_backend]' and @id='wppool-wp_dark_mode_general[enable_backend]' and @value='on' and @checked='checked']"), "Dark Mode Enabled");
    private final IButton saveButton = getElementFactory().getButton(By.xpath("//input[@id='save_settings' and @value='Save Settings']"), "Save Button");
    private final IButton toggleDarkModeBtn = getElementFactory().getButton(By.xpath("//div[contains(@class, 'wp-dark-mode-switcher') and contains(@class, 'wp-dark-mode-ignore') and contains(@class, 'active')]"),"Toggle Dark Mode Button");
    private final IButton dashboardBtn = getElementFactory().getButton(By.xpath("//a[@href='index.php']/div[@class='wp-menu-name' and text()='Dashboard']"), "Dashboard Button");
    private final IButton switchSettingsBtn = getElementFactory().getButton(By.xpath("//a[@href='#wp_dark_mode_switch' and @id='wp_dark_mode_switch-tab']"), "Switch Settings Button");
    private final ILabel floatingSwitchStyle = getElementFactory().getLabel(By.xpath("//img[@src='http://localhost/demosite/wp-content/plugins/wp-dark-mode/assets/images/button-presets/3.png' and @class='image-choose-img']"), "Floating Style");
    private final ILabel switchPosition = getElementFactory().getLabel(By.xpath("//select[@id='wp_dark_mode_switch[switcher_position]' and @name='wp_dark_mode_switch[switcher_position]']"), "Switch Position Dropdown");
    private final ILabel keyboardShortcut = getElementFactory().getLabel(By.xpath("//input[@type='checkbox' and @name='wp_dark_mode_accessibility[keyboard_shortcut]' and @id='wppool-wp_dark_mode_accessibility[keyboard_shortcut]' and @value='on' and @checked='checked'"), "Keyboard Shortcut Button");
    private final ILabel animationSettings = getElementFactory().getLabel(By.xpath("//a[@href='#wp_dark_mode_animation']"), "Animation Settings");
    private final ICheckBox darkmodeToggleAnimation = getElementFactory().getCheckBox(By.xpath("//input[@type='checkbox' and @name='wp_dark_mode_animation[toggle_animation]' and @value='on' and @checked='checked']"), "Darkmode Toggle Animation");
    private final ILabel animationEffectDropdown = getElementFactory().getLabel(By.xpath("//select[@id='wp_dark_mode_animation[animation]' and @name='wp_dark_mode_animation[animation]']"), "Animation Effect Dropdown");

    private final IButton accessibilitySetting = getElementFactory().getButton(By.xpath("//a[@href='#wp_dark_mode_accessibility']"), "Accessibility Setting");


    public WPdarkModePage() {
        super(By.xpath("//h2[@style='display: flex;' and contains(text(), 'WP Dark Mode Settings')]"), "WP Dark Mode Page's Unique Element");
    }

    public void clickOnbackendElementDarkMode() {
        if (!darkModeSwitch.state().isExist()) {
            backendElementDarkMode.clickAndWait();
            saveButton.clickAndWait();
        }
    }
    public boolean checkWPDarkModeWorkingOrNot() {
        return toggleDarkModeBtn.state().isExist();
    }

    public void clickOnDashboardBtn() {
        dashboardBtn.clickAndWait();
    }

    public void clickOnSwitchSettings() {
        switchSettingsBtn.clickAndWait();
    }

    public void selctFloatingStyle() {
        floatingSwitchStyle.clickAndWait();
        saveButton.clickAndWait();
    }

    public void clickOnSwitchPosition() {
        switchPosition.clickAndWait();
    }

    public void selectSwitchPosition() {
        // Locate the specific option element by its text
        WebElement selectElement = AqualityServices.getBrowser().getDriver().findElement(By.id("wp_dark_mode_switch[switcher_position]"));

        // Create a Select object
        Select select = new Select(selectElement);

        // Select "Left Bottom" from the dropdown by visible text
        select.selectByVisibleText("Left Bottom");
        saveButton.clickAndWait();
    }

    public boolean isLeftBottomSelected() {
        Select select = new Select(switchPosition.getElement());
        WebElement selectedOption = select.getFirstSelectedOption();
        return selectedOption.getText().equals("Left Bottom");
    }

    public void navigateToAccessibilitySetting() {
        accessibilitySetting.clickAndWait();
    }

    public void disableKeyboardShortcut() {
        if (keyboardShortcut.state().isExist()) {
            keyboardShortcut.clickAndWait();
            saveButton.clickAndWait();
        }
    }

    public void navigateToAnimationSettings() {
        animationSettings.clickAndWait();
    }

    public void enableDarkmodeToggleAnimation() {
        if (!darkmodeToggleAnimation.state().isExist()) {
            darkmodeToggleAnimation.clickAndWait();
        }
    }

    public void selectAnimationEffect(String effect) {
        animationEffectDropdown.clickAndWait();

        // Create a Select object for the dropdown
        Select animationDropdown = new Select(animationEffectDropdown.getElement());

        // Select the desired option by its value attribute
        animationDropdown.selectByValue(effect);
    }

    public void saveSettings() {
        saveButton.clickAndWait();
    }
}
