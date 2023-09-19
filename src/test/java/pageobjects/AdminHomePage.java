package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AdminHomePage extends Form {
    private final ILabel wpdarkmodePlugin = getElementFactory().getLabel(By.xpath("//a[@href='admin.php?page=wp-dark-mode-settings' and contains(@class, 'wp-has-submenu') and contains(@class, 'menu-top') and contains(@class, 'toplevel_page_wp-dark-mode-settings') and @aria-haspopup='true' and div[@class='wp-menu-name']='WP Dark Mode']"), "WP Dark Mode Plugin");
    private final IButton wpPageBtn = getElementFactory().getButton(By.xpath("//div[contains(@class, 'wp-menu-name') and text()='WP Dark Mode']"), "WP Page Button");

    public AdminHomePage() {
        super(By.xpath("//h1[text()='Dashboard']"), "Unique Element of Admin Home Page");
    }

    public boolean checkWpDarkModeActiveorNot() {
        return wpdarkmodePlugin.state().isDisplayed();
    }

    public void clickOnWPpageButton() {
        if (checkWpDarkModeActiveorNot()) {
            wpPageBtn.clickAndWait();
        }
    }

}
