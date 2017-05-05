package twindy.common.exception;

public class ForbiddenException extends BaseException {

    private static final long serialVersionUID = 4503928757030939304L;

    private String reason;

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, String reason) {
        super(message);
        this.reason = reason;
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getDetails() {
        return this.reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
