package runner;

import utilities.ExtentReport;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(features = {"src/test/java/features"}, glue = {"steps"}, format = {"json:target/cucumber-json-report.json", "html:target/cucumber-report-html"})
public class TestRunner {


    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(dataProvider = "features")
    public void CheckOutTest(CucumberFeatureWrapper cucumberFeatureWrapper) throws ClassNotFoundException {
        var featureName  = cucumberFeatureWrapper.getCucumberFeature().getGherkinFeature().getName();
        ExtentReport.startFeature(featureName);
        testNGCucumberRunner.runCucumber
                (cucumberFeatureWrapper.getCucumberFeature());
    }
    @Test(dataProvider = "features")
    public void HomeTest(CucumberFeatureWrapper cucumberFeatureWrapper) throws ClassNotFoundException {
        var featureName = cucumberFeatureWrapper.getCucumberFeature().getGherkinFeature().getName();
        ExtentReport.startFeature(featureName);
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }
    @DataProvider
    public Object[] features(ITestContext context) {
        var featureName = testNGCucumberRunner.provideFeatures();
        Object[] getFeature = null;
        for(Object[] item : featureName){
            if(item[0].toString().equalsIgnoreCase(context.getName())){
                getFeature = item;
            }
        }
        return getFeature;
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }


}

