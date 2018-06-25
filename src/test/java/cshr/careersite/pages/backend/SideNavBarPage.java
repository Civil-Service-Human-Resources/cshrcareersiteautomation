package cshr.careersite.pages.backend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
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

    @FindBy(className = "ab-icon")
    public WebElementFacade mobileHamburgerMenu;

    public boolean sideNavContainsHeadingsList(String[] strHeadingsList)
    {
        if(mobileHamburgerMenu.isCurrentlyVisible())
        {
            mobileHamburgerMenu.click();
        }
        List<String> temp = new ArrayList<String>();

        for (WebElement G : sideNavMainHeadings ) {
            if(G.getText().contains("Workflows"))
            {
                temp.add("Workflows");
            }
            else if(G.getText().contains("Plugins"))
            {
                temp.add("Plugins");
            }
            else {
                temp.add(G.getText());
            }
        }

        List<String> headlingArrayList = new ArrayList<String>(Arrays.asList(strHeadingsList));

        return temp.containsAll(headlingArrayList);
    }

}
