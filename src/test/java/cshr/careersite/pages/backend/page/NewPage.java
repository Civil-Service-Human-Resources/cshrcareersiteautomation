package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class NewPage extends PageObject {
    public void openNewPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/post-new.php?post_type=page");
    }

    @FindBy(id = "title")
    public WebElementFacade pageName;

    @FindBy(id = "insert-media-button")
    public WebElementFacade addMediaButton;

    @FindBy(id = "content_ifr")
    private WebElementFacade htmlBodyFrame;

    @FindBy(id = "tinymce")
    private WebElementFacade htmlBody;

    @FindBy(id = "workflow_submit")
    public WebElementFacade submitWorkflowButton;

    @FindBy(id = "page_template")
    public WebElementFacade pageTemplate;

    @FindBy(id = "publish")
    public WebElementFacade publish;

    private String strTeamCheckbox = "in-rpg-%s";

    public void editHTMLBody(String body)
    {
        getDriver().switchTo().frame(htmlBodyFrame);
        typeInto(htmlBody, body);
        getDriver().switchTo().defaultContent();
    }

    public void selectTeam(String teamName)
    {
        element(String.format(strTeamCheckbox, teamName.toLowerCase())).click();
    }
}
