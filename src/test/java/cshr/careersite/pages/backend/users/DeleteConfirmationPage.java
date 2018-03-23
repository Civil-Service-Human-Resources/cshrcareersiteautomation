package cshr.careersite.pages.backend.users;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class DeleteConfirmationPage extends PageObject {
    @FindBy(id = "submit")
    public WebElementFacade confirmDelete;

    @FindBy(id = "delete_option0")
    public WebElementFacade deleteAllContent;

}
