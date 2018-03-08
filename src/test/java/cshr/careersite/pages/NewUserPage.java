package cshr.careersite.pages;

import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static net.serenitybdd.core.SerenitySystemProperties.getProperties;

//@NamedUrl(name = "newuser.page", url = "/user-new.php")
public class NewUserPage extends PageObject{
    String property = SerenitySystemProperties.getProperties().getValue(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl + "/user-new.php");
    }
}
