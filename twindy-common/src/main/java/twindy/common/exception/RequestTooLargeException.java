package twindy.common.exception;

/**
 * Created by Tom Goong on 2016/1/4.
 */
public class RequestTooLargeException extends BaseException {

    private static final long serialVersionUID = 2217053383104850457L;

    private String largeResource;  //太大的资源

    public RequestTooLargeException(String message) {
        super(message);
    }

    public RequestTooLargeException(String message, String largeResource) {
        super(message);
        this.largeResource = largeResource;
    }

    public RequestTooLargeException(String message, Object[] formatValues) {
        super(message, formatValues);
    }

    public RequestTooLargeException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getDetails() {
        return largeResource == null ? null : ("resource: " + largeResource);
    }
}
