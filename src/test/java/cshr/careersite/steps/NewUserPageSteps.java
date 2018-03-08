package cshr.careersite.steps;

import cshr.careersite.pages.NewUserPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class NewUserPageSteps {

    NewUserPage newUserPage;

    @Step
    public boolean creatNewUser() {
        newUserPage.open();

        String username = newUserPage.createNewUser();

        Serenity.setSessionVariable("User Name").to(username);
        return username.equals("USER_CREATION_FAILED");
    }
}
