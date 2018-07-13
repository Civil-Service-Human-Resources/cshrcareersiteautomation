package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SubContentWithImage extends PageObject {

    @FindBy(css = "[data-name ='sub_content'] [data-name ='body'] textarea")
    public WebElementFacade subContentWithImageBody;

    @FindBy(css = "[data-name ='sub_content'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade subContentWithImageHeading;

    @FindBy(css = "[data-name ='sub_content'] [data-name ='image_1'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade subContentWithImageImage1;

    @FindBy(css = "[data-name ='sub_content'] [data-name ='image_2'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade subContentWithImageImage2;
}
