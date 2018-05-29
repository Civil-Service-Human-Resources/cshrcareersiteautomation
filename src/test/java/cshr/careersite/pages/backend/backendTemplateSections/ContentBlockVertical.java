package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContentBlockVertical extends PageObject {
    @org.openqa.selenium.support.FindBy(css = "[data-name ='content_block_vertical'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockVerticalImage;

    @org.openqa.selenium.support.FindBy(css = "[data-name ='content_block_vertical'] [data-name ='quote'] textarea")
    public WebElementFacade contentBlockVerticalQuote;

    @org.openqa.selenium.support.FindBy(css = "[data-name ='content_block_vertical'] [data-name ='forename'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalForename;

    @org.openqa.selenium.support.FindBy(css = "[data-name ='content_block_vertical'] [data-name ='surname'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalSurname;

    @org.openqa.selenium.support.FindBy(css = "[data-name ='content_block_vertical'] [data-name ='role'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalRole;
}
