package org.denys.hudymov;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class AgreePrivacy implements Runnable{
    private WebDriver chromeDriver;
    private final Object lock;

    public AgreePrivacy(WebDriver chromeDriver, Object lock) {
        this.chromeDriver = chromeDriver;
        this.lock = lock;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement agreeButton;
            try {
                agreeButton = chromeDriver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]"));
            }catch (NoSuchElementException e){
                agreeButton = null;
            }
            if(agreeButton != null){
                agreeButton.click();
                synchronized (lock) {
                    lock.notifyAll();
                    lock.wait();
                }
            }
        }
    }
}
