package base;


import base.BasePage;

public class CurrentPageContext {
    private static ThreadLocal<BasePage> localCurrentPage = new ThreadLocal<>();
    public static BasePage getCurrentPage(){
        return localCurrentPage.get();
    }
    public static void setLocalCurrentPage(BasePage driverThreadLocal){
        localCurrentPage.set(driverThreadLocal);
    }
}
