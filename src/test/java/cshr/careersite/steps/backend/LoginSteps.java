package cshr.careersite.steps.backend;

import cshr.careersite.pages.backend.CareerSiteHomePage;
import cshr.careersite.pages.backend.CareerSiteLoginPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class LoginSteps {
    CareerSiteLoginPage careerSiteLoginPage;
    CareerSiteHomePage careerSiteHomePage;


    @Step
    public void logoutAndLoginWithDifferentCredentials(String username, String password)
    {
        openLoginPage();
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
        else if(defaultUserName.equals("contentsnippets"))
        {
            username = "ContentSnippets1";
            password = "Cj92zbI4nVLFsmWvC85aR1Uy";
        }
        openLoginPage();
        careerSiteLoginPage.login(username, password);
    }

    @Step
    public boolean isLoggedinUserNameCorrect(String username)
    {
        return careerSiteHomePage.loggedInAs.getText().replaceAll("\\s","").contains(username);
    }

    private void openLoginPage()
    {
        careerSiteLoginPage.openLoginPage();
        careerSiteHomePage.logout();
    }

    @ManagedPages
    public Pages pages;

    public void setBaseURLFromSerenityProperties()
    {
        Serenity.setSessionVariable("BASE_URL").to(pages.getConfiguration().getEnvironmentVariables().getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName()));
        Serenity.setSessionVariable("BACKEND_BASE_URL").to(pages.getConfiguration().getEnvironmentVariables().getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName()) + "wp-admin/");
    }
}
