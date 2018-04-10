package cshr.careersite.model;

public class PageTableColumns {

    private String pageTitle;
    private String pageStatus;
    private String pageAuthor;
    private String dateStatus;
    private String teamList;

    public PageTableColumns(String pageTitle, String pageStatus, String pageAuthor, String dateStatus, String teamList) {
        this.pageTitle = pageTitle;
        this.pageStatus = pageStatus;
        this.pageAuthor = pageAuthor;
        this.dateStatus = dateStatus;
        this.teamList = teamList;
    }


    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageStatus() {
        return pageStatus;
    }

    public void setPageStatus(String pageStatus) {
        this.pageStatus = pageStatus;
    }

    public String getPageAuthor() {
        return pageAuthor;
    }

    public void setPageAuthor(String pageAuthor) {
        this.pageAuthor = pageAuthor;
    }

    public String getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(String dateStatus) {
        this.dateStatus = dateStatus;
    }

    public String getTeamList() {
        return teamList;
    }

    public void setTeamList(String teamList) {
        this.teamList = teamList;
    }
}
