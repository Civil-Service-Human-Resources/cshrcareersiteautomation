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

   /* public TemplateElement billboardLogoText = new TemplateElement();
    public TemplateElement billboardLogo = new TemplateElement();
    public TemplateElement billboardHeading = new TemplateElement();
    public TemplateElement billboardIntroText = new TemplateElement();
    public TemplateElement billboardImage = new TemplateElement();

    public void setDefaultBillboardObject()
    {
        billboardLogoText.elementName = logoText;
        billboardLogoText.elementType = "input";
        billboardLogoText.isElementMandatory = true;
        billboardLogoText.elementLength = 45;

        billboardLogo.elementName = logo;
        billboardLogo.elementType = "image";
        billboardLogo.isElementMandatory = true;

        billboardHeading.elementName = heading;
        billboardHeading.elementType = "input";
        billboardHeading.isElementMandatory = true;
        billboardHeading.elementLength = 70;

        billboardIntroText.elementName = introText;
        billboardIntroText.elementType = "textarea";
        billboardIntroText.isElementMandatory = true;
        billboardIntroText.elementLength = 350;

        billboardImage.elementName = bImage;
        billboardImage.elementType = "image";
        billboardImage.isElementMandatory = true;
    }*/
}
