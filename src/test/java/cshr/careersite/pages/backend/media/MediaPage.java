package cshr.careersite.pages.backend.media;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

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

    @FindBy(css = "button[id='__wp-uploader-id-1']")
    public WebElementFacade selectFiles;

    @FindBys({@FindBy(css = "li[class='attachment save-ready']"),})
    public List<WebElementFacade> mediaList;

    @FindBy(className = "no-media")
    public WebElementFacade noMedia;

    @FindBy(css = "input[name='save'][value='Update']")
    public WebElementFacade update;

    @FindBy(id = "__wp-uploader-id-0")
    public WebElementFacade attachmentPage;

    public boolean uploadMedia(String fileName)
    {
        selectFiles.waitUntilVisible();

        String fileNameWithoutPath = fileName.substring(fileName.lastIndexOf('/') + 1);
        String fileNameWithoutExt = fileNameWithoutPath.split("\\.")[0];
        if(!checkIfMediaExists(fileNameWithoutExt)) {

            getDriver().findElement(By.xpath("//input[starts-with(@id,'html5_')]")).sendKeys(fileName);
            withTimeoutOf(30, SECONDS).elementIsCurrentlyVisible(By.id("title"));
            return true;
        }

        return false;
    }

    public boolean checkIfMediaExists(String fileName)
    {

        if(!noMedia.isCurrentlyVisible()) {
            for (WebElement w : mediaList) {
                if (w.getAttribute("aria-label").toLowerCase().contains(fileName.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;

    }

    public void selectTeam(boolean Team1, boolean Team2)
    {
        String team = "[class='compat-field-team-%s'] td label";

        if(Team1)
        {
            element(By.cssSelector(String.format(team, "2"))).click();
        }

        if(Team2)
        {
            element(By.cssSelector(String.format(team, "3"))).click();
        }
        update.waitUntilVisible();
        update.sendKeys(Keys.ENTER);
    }
}
