package cshr.careersite.steps;

import cshr.careersite.pages.CareerSiteLoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class GenericStepDefs {
    CareerSiteLoginPage careerSiteLoginPage;

    @Given("^I am logged in as a (techadmin|contentadmin|contentauthor|contentapprover|contentpublisher)")
    public void iAmLoggedInAsATechadmin(String admin) throws Throwable {
        String username= "", password ="";

        if(admin.equals("techadmin"))
        {
            username = "techadmin";
            password = "W^E4n9uoFGDvMcX@xz";
        }
        else if(admin.equals("contentadmin"))
        {
            username = "ContentAdmin1";
            password = "19Q4RjFXBNFczTd9k0mkZFzM";
        }
        else if(admin.equals("contentauthor"))
        {
            username = "ContentAuthor1";
            password = "*dr%moW73FJXE1l20jbJw*p1";
        }
        else if(admin.equals("contentapprover"))
        {
            username = "ContentApprover1";
            password = "Op$Eo$vJZZgggoJW!e6f%S4V";
        }
        else if(admin.equals("contentpublisher"))
        {
            username = "ContentPublisher1";
            password = "VmN0ZgqpNCkP!n0Xfrz$w$Cg";
        }

        careerSiteLoginPage.open();
        careerSiteLoginPage.login(username, password);

    }
}
