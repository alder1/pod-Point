package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    @FindBy(how = How.ID,using = "vehicleBrand")
    public WebElement carMake;

    @FindBy(how = How.ID,using = "vehicleId")
    public WebElement carModel;

    @FindBy(how = How.XPATH,using = "//span[text()='I am NOT eligible to claim the dealership discount']")
    public WebElement notEligible;

    @FindBy(how = How.XPATH,using = "//span[text()= 'Universal Socket']")
    public WebElement connectionType;

    @FindBy(how = How.XPATH,using = "//h4[text()='7KW']")
    public WebElement powerRating;

    @FindBy(how = How.XPATH,using = "//h4[text()='Key lock']")
    public WebElement extras;

    @FindBy(how = How.XPATH,using = "h3[text()='£918.00']")
    public WebElement totalCost;

    public void selCarMake(String str){
        Select sel = new Select(carMake);
        sel.selectByVisibleText("Mitsubishi");
    }

    public void selCarModel(String str){
        Select sel = new Select(carModel);
        sel.selectByVisibleText("Outlander");
    }
    public void clickElibibility(){
        notEligible.click();
    }
    public void clickConnectionType(){
        connectionType.click();
    }
    public void clickPowerRating(){
        powerRating.click();
    }
    public void clickCompatibleExtras(){
        extras.click();
    }
    public boolean assertCost() {
        return totalCost.isDisplayed();
    }
}
