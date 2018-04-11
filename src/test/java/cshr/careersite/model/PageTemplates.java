package cshr.careersite.model;

public enum PageTemplates {
    DEPARTMENT_PAGE_TEMPLATE("page-layout-a.php"),
    HOME_PAGE_TEMPLATE("page-home.php");

    private String value;

    public String getValue() {
        return value;
    }
    private PageTemplates(String value) {
        this.value = value;
    }
}
