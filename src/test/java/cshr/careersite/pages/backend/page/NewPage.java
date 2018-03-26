package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
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

    @FindBy(id = "save-post")
    public WebElementFacade save;

    @FindBy(xpath = "//a[text()='Take over']")
    public WebElementFacade takeOver;

    @FindBy(id = "wp-content-editor-container")
    private WebElementFacade content;

    @FindBy(className = "wp-editor-area")
    private WebElementFacade htmlBodyForApprover;

    @FindBy(css = "[class='misc-pub-section misc-pub-revisions'] a")
    public WebElementFacade browseRevisions;

    private String strTeamCheckbox = "in-rpg-%s";

    public void editHTMLBody(String body)
    {
        // The content area seems to be different for different logins.
        if(htmlBodyForApprover.isCurrentlyVisible())
        {
            typeInto(htmlBodyForApprover, body);
        }
        else {
            getDriver().switchTo().frame(htmlBodyFrame);
            typeInto(htmlBody, body);
            getDriver().switchTo().defaultContent();
        }
    }

    public String getHTMLBody()
    {
        waitABit(2000);

        return content.getText();
    }

    public void selectTeam(String teamName)
    {
        element(By.id(String.format(strTeamCheckbox, teamName.toLowerCase()))).click();
    }
}
