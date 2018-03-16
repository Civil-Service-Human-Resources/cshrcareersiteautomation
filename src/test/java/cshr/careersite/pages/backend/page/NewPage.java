package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@NamedUrls({@NamedUrl(name = "new.page", url = "/post-new.php?post_type=page")})
public class NewPage extends PageObject {

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    @FindBy(id = "post_title")
    public WebElementFacade pageName;

    @FindBy(id = "insert-media-button")
    public WebElementFacade addMediaButton;

    @FindBy(id = "tinymce")
    public WebElementFacade htmlBody;

    @FindBy(id = "workflow_submit")
    public WebElementFacade submitWorkflowButton;

    @FindBy(id = "page_template")
    public WebElementFacade pageTemplate;

}
