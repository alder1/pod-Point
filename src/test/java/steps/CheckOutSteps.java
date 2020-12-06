package steps;

import base.Base;
import base.CurrentPageContext;
import com.aventstack.extentreports.GherkinKeyword;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.CheckOutPage;
import utilities.ExtentReport;

public class CheckOutSteps extends Base {

    @Given("^I am on the checkout page$")
    public void i_am_on_the_checkout_page() throws ClassNotFoundException {
        CurrentPageContext.setLocalCurrentPage(GetInstance(CheckOutPage.class));
        ExtentReport.getScenario().createNode(new GherkinKeyword("Given"),"I am on on the checkout page");
    }

    @When("^I select any car with different features of my choice$")
    public void i_select_any_car_with_different_features_of_my_choice() throws ClassNotFoundException {
     CurrentPageContext.getCurrentPage().As(CheckOutPage.class).selCarMake("Mitsubishi");
     CurrentPageContext.getCurrentPage().As(CheckOutPage.class).selCarModel("Outlander");
     CurrentPageContext.getCurrentPage().As(CheckOutPage.class).clickElibibility();
     CurrentPageContext.getCurrentPage().As(CheckOutPage.class).clickConnectionType();
     CurrentPageContext.getCurrentPage().As(CheckOutPage.class).clickPowerRating();
     CurrentPageContext.getCurrentPage().As(CheckOutPage.class).clickCompatibleExtras();

    }

    @Then("^the correct price of the selected features should be displayed at the bottom of the page$")
    public void the_correct_price_of_the_selected_features_should_be_displayed_at_the_bottom_of_the_page() throws ClassNotFoundException {
        Assert.assertTrue("£918.00",CurrentPageContext.getCurrentPage().As(CheckOutPage.class).assertCost());
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"),"The correct price should be displayed at the bottom of the page ");
    }
}
