package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SubContentMultiple extends PageObject {
    @FindBys(@FindBy(css ="[data-name='sub_content_multiple'] [data-name='content_area_content_block_with_3_paras'] [data-name='heading'] input:not([type='hidden'])"))
    public List<WebElementFacade> subContentMultipleContentAreaContentBlockWith3ParasHeading;

    @FindBys(@FindBy(css = "[data-name='sub_content_multiple'] [data-name='content_area_content_block_with_3_paras'] [data-name='paragraph_1'] textarea:not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> subContentMultipleContentAreaContentBlockWith3ParasParagraph1;

    @FindBys(@FindBy(css ="[data-name='sub_content_multiple'] [data-name='content_area_content_block_with_3_paras'] [data-name='paragraph_2'] [class='acf-input'] [class='wp-editor-container'] textarea"))
    public List<WebElementFacade> subContentMultipleContentAreaContentBlockWith3ParasParagraph2;

    @FindBys(@FindBy(css ="[data-name='sub_content_multiple'] [data-name='content_area_content_block_with_3_paras'] [data-name='paragraph_3'] textarea:not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> subContentMultipleContentAreaContentBlockWith3ParasParagraph3;
}
