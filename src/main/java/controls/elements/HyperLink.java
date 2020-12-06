package controls.elements;

import controls.api.ImplementedBy;
import controls.internals.Control;
import controls.internals.ControlBase;


@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {
    void ClickLink();
    String GetUrlText();
    boolean CheckUrlTextContains(String containsText);
    ControlBase Wait();
    ControlBase WaitForVisible();
    ControlBase Click();
}
