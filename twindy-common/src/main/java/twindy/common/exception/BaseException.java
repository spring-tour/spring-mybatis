package twindy.common.exception;

/**
 * @author senola
 * @time 2017-05-04
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4713188356711358759L;

    private transient final Object[] formatValues;  //将信息格式化到异常的message中


    public BaseException(String message) {
        super(message);
        this.formatValues = null;
    }

    public BaseException(String message, Object[] formatValues) {
        super(message);
        this.formatValues = formatValues;
    }


    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.formatValues = null;
    }

    public Object[] getFormatValues() {
        return formatValues;
    }

    public String getDetails() {
        return null;
    }
}
