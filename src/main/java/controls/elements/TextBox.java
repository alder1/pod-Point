package controls.elements;

import controls.api.ImplementedBy;
import controls.internals.Control;


@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {
    void EnterText(String text);
    String GetTextValue();
}
