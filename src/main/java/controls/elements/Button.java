package controls.elements;

import controls.api.ImplementedBy;
import controls.internals.Control;
import controls.internals.ControlBase;


@ImplementedBy(ButtonBase.class)
public interface Button extends Control {
    void PerformClick();
    String GetButtonText();
    void PerformSubmit();
    ControlBase Wait();
    ControlBase WaitForVisible();
    ControlBase Click();
}
