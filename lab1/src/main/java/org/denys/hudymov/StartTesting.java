package org.denys.hudymov;


public class StartTesting
{
    public static void main( String[] args )
    {
        PastebinAutoTest pastebinAutoTest= new PastebinAutoTest();
        DemoWebShopTest demoWebShopTest= new DemoWebShopTest();
        pastebinAutoTest.startTest();
        demoWebShopTest.startTest();
    }
}
