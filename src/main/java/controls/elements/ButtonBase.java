package controls.elements;

import controls.internals.ControlBase;
import org.openqa.selenium.WebElement;


public class ButtonBase extends ControlBase implements Button {
    public ButtonBase(WebElement element){
    super(element);
    }
    @Override
    public void PerformClick() {
      getWrappedElement().click();
    }

    @Override
    public void PerformSubmit() {
    getWrappedElement().submit();
    }

    @Override
    public String GetButtonText() {
      return getWrappedElement().getText();
    }

}
