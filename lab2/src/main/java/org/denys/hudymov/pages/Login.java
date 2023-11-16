package org.denys.hudymov.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "Email")
    WebElement email;
    @FindBy(how = How.ID, using = "Password")
    WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@class = 'button-1 login-button']")
    WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//span[text()='Login was unsuccessful. Please correct the errors and try again.']")
    WebElement loginError;


    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
