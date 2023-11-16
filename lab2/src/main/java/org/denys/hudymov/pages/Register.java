package org.denys.hudymov.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
public class Register {

    private WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "gender-male")
    WebElement gender;
    @FindBy(how = How.NAME, using = "FirstName")
    WebElement firstName;
    @FindBy(how = How.NAME, using = "LastName")
    WebElement lastName;
    @FindBy(how = How.ID, using = "Email")
    WebElement email;
    @FindBy(how = How.ID, using = "Password")
    WebElement password;
    @FindBy(how = How.ID, using = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(how = How.ID, using = "register-button")
    WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//li[text()='The specified email already exists']")
    WebElement error;

    public void setGender() {
        this.gender.click();
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void clickRegister() {
        registerButton.click();
    }
}
