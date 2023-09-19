package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {
    private final ITextBox usernameInput = getElementFactory().getTextBox(By.xpath("//input[@id='user_login']"), "Username Input Field");
    private final ITextBox passwordInput = getElementFactory().getTextBox(By.xpath("//input[@id='user_pass']"), "Password Input Filed");
    private final IButton loginButton = getElementFactory().getButton(By.xpath("//input[@id='wp-submit' and contains(@class, 'button-primary')]"), "Login Button");

    public LoginPage() {
        super(By.xpath("//a[text()='Powered by WordPress']"), "Unique Element");
    }

    public void enterUsername(String username) {
        usernameInput.clearAndType(username);
    }

    public void enterPassword(String password) {
        passwordInput.clearAndType(password);
    }

    public void clickOnLoginBtn() {
        loginButton.clickAndWait();
    }
}
