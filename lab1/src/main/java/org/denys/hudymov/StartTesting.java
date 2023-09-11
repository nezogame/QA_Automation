package org.denys.hudymov;


public class StartTesting
{
    public static void main( String[] args )
    {
        PastebinAutoTest pastebinAutoTest= new PastebinAutoTest();
        DemoWebShopAutoTest demoWebShopAutoTest = new DemoWebShopAutoTest();
        pastebinAutoTest.startTest();
        demoWebShopAutoTest.startTest();
    }
}
