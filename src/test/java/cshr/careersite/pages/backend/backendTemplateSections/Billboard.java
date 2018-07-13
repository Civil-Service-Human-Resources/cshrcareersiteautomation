package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Billboard extends PageObject{

   @FindBy(css ="[data-name='billboard'] [data-name='logo_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade billboardLogoText;

    @FindBy(css ="[data-name='billboard'] [data-name='logo'] [data-name = 'add']")
    public WebElementFacade billboardLogo;

    @FindBy(css ="[data-name='billboard'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade billboardHeading;

    @FindBy(css ="[data-name='billboard'] [data-name='intro_text'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade billboardIntroText;

    @FindBy(css ="[data-name='billboard'] [data-name='image'] [data-name = 'add']")
    public WebElementFacade billboardImage;

    @FindBy(css = "[data-name ='billboard'] [data-name ='paragraph_1'] textarea")
    public WebElementFacade billboardParagraph1;

   @FindBy(css = "[data-name ='billboard'] [data-name ='paragraph_2'] textarea")
   public WebElementFacade billboardParagraph2;

   @FindBy(css = "[data-name ='billboard'] [data-name ='paragraph_3'] textarea")
   public WebElementFacade billboardParagraph3;

   @FindBy(css = "[data-name ='billboard'] [data-name ='paragraph_4'] textarea")
   public WebElementFacade billboardParagraph4;
}
