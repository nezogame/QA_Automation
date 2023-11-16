package org.denys.hudymov.pages;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterTest {
    WebDriver driver;

    @BeforeEach
    public void initialize() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register");
    }

    @Test
    public void register() {
        var email = "hudymovDenys@gmail.com";
        var password = "123456";
        Register register = PageFactory.initElements(driver, Register.class);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        register.setGender();
        register.setFirstName("Denys");
        register.setLastName("Hudymov");
        register.setEmail(email);
        register.setPassword(password);
        register.setConfirmPassword(password);
        register.clickRegister();

        Home home = PageFactory.initElements(driver, Home.class);
        home.setLogOut();
        home.setLogIn();

        Login login = PageFactory.initElements(driver, Login.class);
        login.setEmail(email);
        login.setPassword(password);
        login.clickLogin();

        home.setBooksPage();
        home.setAddBtn();
        home.setCart();
        home.setLogOut();
    }

    @Test
    public void accountExist() {
        var email = "denys@gmail.com";
        var password = "123456";
        Register register = PageFactory.initElements(driver, Register.class);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        register.setGender();
        register.setFirstName("Denys");
        register.setLastName("Hudymov");
        register.setEmail(email);
        register.setPassword(password);
        register.setConfirmPassword(password);
        register.clickRegister();
        assertEquals("The specified email already exists", register.getError().getText());
    }

    @Test
    public void incorrectLogin() {
        var email = "12345@gmail.com";
        var password = "123456";
        driver.get("https://demowebshop.tricentis.com/login");
        Login login = PageFactory.initElements(driver, Login.class);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        login.setEmail(email);
        login.setPassword(password);
        login.clickLogin();
        assertEquals("Login was unsuccessful. Please correct the errors and try again.",
                login.getLoginError().getText());
    }

}