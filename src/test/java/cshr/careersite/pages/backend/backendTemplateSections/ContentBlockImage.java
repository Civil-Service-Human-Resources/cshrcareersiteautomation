package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContentBlockImage extends PageObject {
    @FindBy(css ="[data-name='content_block_image'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockImageHeading;

    @FindBy(css ="[data-name='content_block_image'] [data-name='body'] textarea")
    public WebElementFacade contentBlockImageBody;

    @FindBy(css = "[data-name ='content_block_image'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockImageImage;
}
