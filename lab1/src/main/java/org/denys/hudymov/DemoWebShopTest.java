package org.denys.hudymov;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

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
        WebElement element = elementComputers.get(0).findElement(By.cssSelector("input[type='button']"));
        var elementComputer = elementComputers.stream()
                .map(e->e.findElement(By.cssSelector("input[type='button']")))
                .filter(Objects::nonNull)
                .toList();
        //elementComputer.orElseThrow().findElement(By.className("buttons"));
        //act.moveToElement(elementComputer.orElseThrow()).click().build().perform();

        // Click create button
        /*var createButton = chromeDriver.findElement(By.className("btn -big"));
        act.moveToElement(createButton).click().build().perform();*/
    }

    private WebElement findElement(){
        return null;
    }
}
