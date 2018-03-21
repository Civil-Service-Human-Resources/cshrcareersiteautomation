package cshr.careersite.model;

public enum Workflows {
    ACCEPT ("Approved"),
    REJECT ("Reject"),
    COMPLETE ("Complete"),
    UNABLE_TO_COMPLETE("Unable to complete");

    private String value;

    public String getValue() {
        return value;
    }
    private Workflows(String value) {
        this.value = value;
    }
}
