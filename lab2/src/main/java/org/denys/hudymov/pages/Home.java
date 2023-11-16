package org.denys.hudymov.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
public class Home {
    private WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.CLASS_NAME, using = "ico-logout")
    WebElement logOut;
    @FindBy(how = How.CLASS_NAME, using = "ico-login")
    WebElement logIn;
    @FindBy(how = How.XPATH, using = "//a[@href ='/books']")
    WebElement booksPage;
    @FindBy(how = How.XPATH, using = "//input[@value='Add to cart']")
    WebElement addBtn;
    @FindBy(how = How.CLASS_NAME, using = "cart-label")
    WebElement cart;


    public void setLogOut() {
        this.logOut.click();
    }

    public void setLogIn() {
        this.logIn.click();
    }

    public void setBooksPage() {
        this.booksPage.click();
    }

    public void setAddBtn() {
        this.addBtn.click();
    }

    public void setCart() {
        this.cart.click();
    }

}
