package org.denys.hudymov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoWebShopTest {
    DemoWebShopAutoTest demoWebShopAutoTest;

    @BeforeEach
    void init() {
        demoWebShopAutoTest = new DemoWebShopAutoTest();
    }

    @Test
    void testIfProductAddedCorrectly() {
        demoWebShopAutoTest.startTest();
        var productName = demoWebShopAutoTest.getChromeDriver().findElement(By.className("product-name")).getText();
        assertEquals(productName,demoWebShopAutoTest.getProduct());
    }
}