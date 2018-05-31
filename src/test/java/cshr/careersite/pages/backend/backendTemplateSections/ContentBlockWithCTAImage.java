package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ContentBlockWithCTAImage extends PageObject{

    @FindBy(css ="[data-name='content_block_with_cta_+_image'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAImageHeading;

    @FindBy(css ="[data-name='content_block_with_cta_+_image'] [data-name='paragraph_1'] textarea")
    public WebElementFacade contentBlockWithCTAImageParagraph1;

    @FindBy(css ="[data-name='content_block_with_cta_+_image'] [data-name='paragraph_2'] textarea")
    public WebElementFacade contentBlockWithCTAImageParagraph2;

    @FindBy(css ="[data-name='content_block_with_cta_+_image'] [data-name='cta_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAImageCTAText;

    @FindBy(css ="[data-name='content_block_with_cta_+_image'] [data-name='cta_target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAImageCTATarget;

    @FindBy(css = "[data-name ='content_block_with_cta_+_image'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockWithCTAImageImage;
}
