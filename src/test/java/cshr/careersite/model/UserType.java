package cshr.careersite.model;

public enum UserType {
    TECH_ADMIN ("techadmin"),
    CONTENT_AUTHOR ("contentauthor"),
    CONTENT_PUBLISHER ("contentpublisher"),
    CONTENT_APPROVER ("contentapprover");

    private String value;

    public String getValue() {
        return value;
    }
    private UserType(String value) {
        this.value = value;
    }
}
