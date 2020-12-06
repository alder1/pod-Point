package controls.internals;

import controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;


@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {
    @Override
    Coordinates getCoordinates();
    ControlBase Wait();
    ControlBase WaitForVisible();
    ControlBase Click();
    ControlBase ScrollToElement();
}
