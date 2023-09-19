package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FrontendPage extends Form {
    private final IButton frontendPage = getElementFactory().getButton(By.xpath("//a[text()='Demo Site']"), "Frontend Page");
    private final ILabel wpDarkModeLable = getElementFactory().getLabel(By.xpath("//label[@for='wp-dark-mode-switch']"), "WP Dark Mode Lable");

    public FrontendPage() {
        super(By.xpath("//title[text()='Demo Site']"), "Unique Element of Frontend");
    }

    public void navigateToFrontend() {
        frontendPage.clickAndWait();
    }

    public boolean validateDarkMode() {
        return wpDarkModeLable.state().isExist();
    }
}
