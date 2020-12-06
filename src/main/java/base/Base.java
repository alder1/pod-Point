package base;


import controls.api.ControlFactory;

public class Base {
  public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
        //Page initialization
        Object obj = ControlFactory.initElements(LocalDriverContext.getRemoteWebDriver(),page);
        return page.cast(obj);
  }
}
