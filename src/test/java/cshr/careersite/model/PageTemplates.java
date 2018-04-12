package cshr.careersite.model;

public enum PageTemplates {
    DEPARTMENT_PAGE_TEMPLATE("default"),
    HOME_PAGE_TEMPLATE("page-home.php"),
    DEFAULT_TEMPLATE("page-hub.php");


    private String value;

    public String getValue() {
        return value;
    }
    private PageTemplates(String value) {
        this.value = value;
    }
}
