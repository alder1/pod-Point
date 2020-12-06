package runner;

import config.ConfigReader;
import config.Settings;
import utilities.LogUtil;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestNgListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult testResult){
       //This will initialize config
        if (!iInvokedMethod.isTestMethod()){
           try {
               ConfigReader.PopulateSettings();
           } catch (IOException e) {
               e.printStackTrace();
           }
           //Logging
            Settings.Logs = new LogUtil();
            try {
                Settings.Logs.CreateLogFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Settings.Logs.Write("Framework initialized");

            Settings.Logs.Write("Test cycle Created");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
