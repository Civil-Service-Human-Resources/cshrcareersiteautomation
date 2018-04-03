package cshr.careersite.pages.backend.media;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MediaPage extends PageObject {

    public void openAllMediaPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/upload.php");
    }

    @FindBys({@FindBy(css = "[class=thumbnail] img"),})
    public List<WebElement> imageList;

    @FindBy(css = "[class='page-title-action aria-button-if-js']")
    public WebElementFacade addMedia;

    @FindBy(xpath = "//input[starts-with(@id,'html5_')]")
    public WebElementFacade inputFileName;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElementFacade selectFiles;

    public void uploadMedia(String fileName)
    {
        selectFiles.waitUntilVisible();
        getDriver().findElement(By.xpath("//input[starts-with(@id,'html5_')]")).sendKeys(fileName);
    }
}
