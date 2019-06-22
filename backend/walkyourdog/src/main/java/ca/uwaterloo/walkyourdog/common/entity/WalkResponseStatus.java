package ca.uwaterloo.walkyourdog.common.entity;

public enum WalkResponseStatus {
    MESSAGE_FOUND("200", "Message found"),
    MESSAGE_NOT_FOUND("400", "Message not found");
    private String appCode;
    private String message;

    public String getAppCode() {
        return this.appCode;
    }

    public String getMessage() {
        return this.message;
    }
    WalkResponseStatus(String appCode, String message) {
        this.appCode = appCode;
        this.message = message;
    }
}
