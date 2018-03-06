package cshr.careersite.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SideNavBarPage extends PageObject {

    @FindBys({@FindBy(css="[class='wp-menu-name']"),})
    public List<WebElement> sideNavMainHeadings;

    @FindBy(css="[class='wp-submenu wp-submenu-wrap'] li :not([class='wp-submenu-head'])")
    public WebElement sideNavSubHeadings;

    public boolean sideNavContainsHeadingsList(String[] strHeadingsList)
    {
        List<String> temp = new ArrayList<String>();
        for (WebElement G : sideNavMainHeadings ) {
            if(G.getText().contains("Workflows"))
            {
                temp.add("Workflows");
            }
            else {
                temp.add(G.getText());
            }
        }

        List<String> headlingArrayList = new ArrayList<String>(Arrays.asList(strHeadingsList));

        return temp.containsAll(headlingArrayList);
    }

}
