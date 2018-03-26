package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class RevisionHistoryPage extends PageObject {

    @FindBy(css = "[class='diff-meta diff-meta-to'] span")
    public WebElementFacade authorName;

    @FindBy(className = "diff-addedline")
    public WebElementFacade addedLine;
}
