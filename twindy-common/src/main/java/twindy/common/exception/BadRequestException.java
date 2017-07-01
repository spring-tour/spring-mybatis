package twindy.common.exception;

/**
 *
 */
public class BadRequestException extends BaseException{

    private String paramName;
    private Object paramValue;
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Object[] formatValues) {
        super(message, formatValues);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String message, String paramName, Object paramValue) {
        super(message);
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public BadRequestException(String message, Throwable cause, String paramName, Object paramValue) {
        super(message, cause);
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    @Override
    public String getDetails() {
        return (paramName == null) ? null : "bad params: " + paramName + " = " + paramValue;
    }

    public Object getParamValue() {
        return paramValue;
    }

    public void setParamValue(Object paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
