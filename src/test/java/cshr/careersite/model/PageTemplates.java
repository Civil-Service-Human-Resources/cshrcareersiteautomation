package cshr.careersite.model;

public enum PageTemplates {
    DEPARTMENT_PAGE_TEMPLATE("default"),
    HOME_PAGE_TEMPLATE("page-home.php"),
    AOW_PAGE_TEMPLATE("page-layout-b.php"),
    AOW_LANDING_PAGE_TEMPLATE("page-hub.php"),
    DEPARTMENT_LANDING_PAGE_TEMPLATE("page-hub-listing.php"),
    GENERIC_PAGE_TEMPLATE("page-simple.php"),
    COMMUNITY_PAGE_TEMPLATE("page-layout-c.php");

    private String value;

    public String getValue() {
        return value;
    }
    private PageTemplates(String value) {
        this.value = value;
    }
}
