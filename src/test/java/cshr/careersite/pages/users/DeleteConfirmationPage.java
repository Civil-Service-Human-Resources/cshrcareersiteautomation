package cshr.careersite.pages.users;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class DeleteConfirmationPage extends PageObject {
    @FindBy(id = "submit")
    public WebElementFacade confirmDelete;

}
