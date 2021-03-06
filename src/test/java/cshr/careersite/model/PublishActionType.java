package cshr.careersite.model;

public enum PublishActionType {
    PUBLISH("publish"),
    REVISE("revise"),
    DELETE("delete"),
    UNPUBLISH("unpublish"),
    SAVE("save");

    private String value;

    public String getValue() {
        return value;
    }
    private PublishActionType(String value) {
        this.value = value;
    }
}
