package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SubContent extends PageObject {

    @FindBy(css = "[data-name ='sub_content'] [data-name ='intro'] textarea")
    public WebElementFacade subContentIntro;

    @FindBy(css = "[data-name ='sub_content'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade subContentHeading;

    @FindBys(@FindBy(css = "[data-name ='sub_content'] [data-name ='driver'] [data-name ='image'] [data-name = 'add']"))
    public List<WebElementFacade> subContentDriverImage;

   @FindBys(@FindBy(css = "[data-name ='sub_content'] [data-name ='driver'] [data-name ='headline'] input:not([type='hidden'])"))
    public List<WebElementFacade> subContentDriverHeadline;

    @FindBys(@FindBy(css ="[data-name ='sub_content'] [data-name ='driver'] [data-name ='link'] input:not([type='hidden'])"))
    public List<WebElementFacade> subContentDriverLink;

    @FindBys(@FindBy(css ="[data-name ='sub_content'] [data-name ='driver'] [data-name ='text'] textarea"))
    public List<WebElementFacade> subContentDriverText;

}
