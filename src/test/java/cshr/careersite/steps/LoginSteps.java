package cshr.careersite.steps;

import cshr.careersite.pages.CareerSiteHomePage;
import cshr.careersite.pages.CareerSiteLoginPage;
import net.thucydides.core.annotations.Step;
import org.aspectj.lang.annotation.Before;

public class LoginSteps {
    CareerSiteLoginPage careerSiteLoginPage;
    CareerSiteHomePage careerSiteHomePage;

    @Step
    public void logoutAndLoginWithDifferentCredentials(String username, String password)
    {
        careerSiteLoginPage.open();
        careerSiteHomePage.logout();
        careerSiteLoginPage.login(username, password);
    }

    @Step
    public void logoutAndLoginWithDifferentCredentials(String defaultUserName)
    {
        String username= "", password ="";

        if(defaultUserName.equals("techadmin"))
        {
            username = "techadmin";
            password = "W^E4n9uoFGDvMcX@xz";
        }
        else if(defaultUserName.equals("contentadmin"))
        {
            username = "ContentAdmin1";
            password = "19Q4RjFXBNFczTd9k0mkZFzM";
        }
        else if(defaultUserName.equals("contentauthor"))
        {
            username = "ContentAuthor1";
            password = "*dr%moW73FJXE1l20jbJw*p1";
        }
        else if(defaultUserName.equals("contentapprover"))
        {
            username = "ContentApprover1";
            password = "Op$Eo$vJZZgggoJW!e6f%S4V";
        }
        else if(defaultUserName.equals("contentpublisher"))
        {
            username = "ContentPublisher1";
            password = "VmN0ZgqpNCkP!n0Xfrz$w$Cg";
        }

        careerSiteLoginPage.open();
        careerSiteHomePage.logout();
        careerSiteLoginPage.login(username, password);
    }

    @Step
    public boolean isLoggedinUserNameCorrect(String username)
    {
        return careerSiteHomePage.loggedInAs.getText().replaceAll("\\s","").contains(username);
    }




}
