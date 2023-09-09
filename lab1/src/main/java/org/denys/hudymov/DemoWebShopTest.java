package org.denys.hudymov;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DemoWebShopTest {
    private WebDriver chromeDriver;

    public DemoWebShopTest() {
        this.chromeDriver = new ChromeDriver();
    }

    public void startTest(){
        chromeDriver.get("http://demowebshop.tricentis.com/");

        var computerButton = chromeDriver.findElement(By.xpath("//a[@href ='/computers']"));
        var desktopButton = chromeDriver.findElement(By.xpath("//a[@href ='/desktops']"));
        Actions act = new Actions(chromeDriver);
        act.moveToElement(computerButton)
                .moveToElement(desktopButton)
                .click()
                .build()
                .perform();

        var sortSelect = new Select(chromeDriver.findElement(By.id("products-orderby")));
        sortSelect.selectByVisibleText("Price: Low to High");

        var viewSelect = new Select(chromeDriver.findElement(By.id("products-viewmode")));
        viewSelect.selectByVisibleText("List");

        var elementComputers = chromeDriver.findElements(By.className("item-box"));
        var elementComputer = findFirstElementWithButton(elementComputers).orElseThrow();


        act.moveToElement(elementComputer)
                .click()
                .moveToElement(chromeDriver.findElement(By.xpath("//input[@value='Add to cart']")))
                .pause(2000).build()
                .perform();

        act.moveToElement(chromeDriver.findElement(By.xpath("//input[@value='Add to cart']")))
                .click()
                .pause(2000)
                .build()
                .perform();

        act.moveToElement(chromeDriver.findElement(By.xpath("//a[@href ='/cart']")))
                .click()
                .build()
                .perform();
    }

    /**
     * This method is used to find a web element from the list of web elements that have a button
     *
     * @param elements a list of WebElement
     * @return first element with button
     */
    private Optional<WebElement> findFirstElementWithButton(List<WebElement> elements){
        return elements.stream()
                .map(e->
                {
                    try {
                        return e.findElement(By.cssSelector("input[type='button']"));
                    }catch (NoSuchElementException noSuchElementException){
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .findFirst();

    }
}
