package org.denys.hudymov;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@Getter @Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class PastebinAutoTest {

    private WebDriver chromeDriver;
    private final Object lock = new Object();

    public PastebinAutoTest() {
        this.chromeDriver = new ChromeDriver();
    }

    public void startTest(){
        chromeDriver.get("https://pastebin.com");

        AgreePrivacy agreePrivacy = new AgreePrivacy(chromeDriver,lock);
        Thread agreePrivacyThread = new Thread(agreePrivacy);
        agreePrivacyThread.start();
        try {
            synchronized (lock){
                lock.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions act = new Actions(chromeDriver);
        var elementPasteText = chromeDriver.findElement(By.id("postform-text"));
        act.moveToElement(elementPasteText)
                .click()
                .sendKeys("Text text text text more text")
                .build()
                .perform();

        var dropdownElement = chromeDriver.findElement(By
                .xpath("//*[@id=\"select2-postform-expiration-container\"]"));
        dropdownElement.click();
        var option10Minutes = chromeDriver.findElement(By.xpath("//li[text()='10 Minutes']"));
        option10Minutes.click();

        var elementTitle = chromeDriver.findElement(By.id("postform-name"));
        act.moveToElement(elementTitle)
                .click()
                .sendKeys("Title Title more Title")
                .build().perform();

        // Click create button
        /*var createButton = chromeDriver.findElement(By.className("btn -big"));
        act.moveToElement(createButton).click().build().perform();*/
    }
}
