package cshr.careersite.model.BackendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Billboard {

    @FindBy(css = "billboard_logo_text")
    private WebElementFacade logoText;

    @FindBy(css = "billboard_logo")
    private WebElementFacade logo;

    @FindBy(css = "billboard_heading")
    private WebElementFacade heading;

    @FindBy(css = "billboard_intro_text")
    private WebElementFacade introText;

    @FindBy(css = "billboard_image")
    private WebElementFacade billboardImage;

    public int logoTextLength;

    public int logoHeadingLength;

    public int logoIntroTextLength;


    public void fillRandomValuesForBillboard()
    {

    }
}
