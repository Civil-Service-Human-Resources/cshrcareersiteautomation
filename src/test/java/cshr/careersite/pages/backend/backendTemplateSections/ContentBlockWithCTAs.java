package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ContentBlockWithCTAs extends PageObject{
    @FindBy(css ="[data-name='content_block_with_cta_1'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAs1Heading;

    @FindBy(css ="[data-name='content_block_with_cta_1'] [data-name='paragraph_1'] textarea")
    public WebElementFacade contentBlockWithCTAs1Paragraph1;

    @FindBy(css ="[data-name='content_block_with_cta_1'] [data-name='paragraph_2'] textarea")
    public WebElementFacade contentBlockWithCTAs1Paragraph2;

    @FindBy(css ="[data-name='content_block_with_cta_1'] [data-name='cta_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAs1CTAText;

    @FindBy(css ="[data-name='content_block_with_cta_1'] [data-name='cta_target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAs1CTATarget;

    @FindBy(css ="[data-name='content_block_with_cta_2'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAs2Heading;

    @FindBy(css ="[data-name='content_block_with_cta_2'] [data-name='paragraph_1'] textarea")
    public WebElementFacade contentBlockWithCTAs2Paragraph1;

    @FindBy(css ="[data-name='content_block_with_cta_2'] [data-name='paragraph_2'] textarea")
    public WebElementFacade contentBlockWithCTAs2Paragraph2;

    @FindBy(css ="[data-name='content_block_with_cta_2'] [data-name='cta_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAs2CTAText;

    @FindBy(css ="[data-name='content_block_with_cta_2'] [data-name='cta_target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAs2CTATarget;
}
